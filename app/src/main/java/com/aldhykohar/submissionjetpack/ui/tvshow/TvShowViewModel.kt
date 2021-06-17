package com.aldhykohar.submissionjetpack.ui.tvshow

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldhykohar.submissionjetpack.data.repository.DataRepository
import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenreResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsResponse
import com.aldhykohar.submissionjetpack.utils.Resource
import kotlinx.coroutines.launch


/**
 * Created by aldhykohar on 5/11/2021.
 */
class TvShowViewModel
@ViewModelInject
constructor(private val repository: DataRepository) : ViewModel() {
    fun getTvShows() = repository.getTvShows()
    fun getTvShowGenre() = repository.getGenreTvShow()

}