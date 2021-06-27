package com.aldhykohar.submissionjetpack.ui.tvshow.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldhykohar.submissionjetpack.data.repository.DataRepository
import com.aldhykohar.submissionjetpack.data.repository.local.entity.TvShowsEntity
import kotlinx.coroutines.launch


/**
 * Created by aldhykohar on 5/11/2021.
 */
class DetailTvShowViewModel
@ViewModelInject
constructor(private val repository: DataRepository) : ViewModel() {

    var isFav = false

    fun setIsFav(state: Boolean) {
        this.isFav = state
    }

    fun getDetailTvShow(tvShowId: Int) = repository.getDetailTvShow(tvShowId)

    fun setFavorite(tvShows: TvShowsEntity) {
        viewModelScope.launch {
            if (!isFav) {
                repository.setTvShowFav(tvShows)
            } else {
                repository.deleteTvShowsFav(tvShows)
            }
        }
    }

    fun checkFavTvShow(tvShowId: Int): LiveData<TvShowsEntity> = repository.checkTvShow(tvShowId)
}