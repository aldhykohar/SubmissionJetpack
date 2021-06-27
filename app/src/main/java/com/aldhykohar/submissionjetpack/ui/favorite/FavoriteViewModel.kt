package com.aldhykohar.submissionjetpack.ui.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.aldhykohar.submissionjetpack.data.repository.DataRepository
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.data.repository.local.entity.TvShowsEntity


/**
 * Created by aldhykohar on 6/26/2021.
 */
class FavoriteViewModel
@ViewModelInject
constructor(private val repository: DataRepository) : ViewModel() {

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> = repository.getMovieFav()
    fun getFavoriteTvSHow(): LiveData<PagedList<TvShowsEntity>> = repository.getTvShowFav()

}