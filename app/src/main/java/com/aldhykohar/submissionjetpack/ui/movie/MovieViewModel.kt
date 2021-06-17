package com.aldhykohar.submissionjetpack.ui.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldhykohar.submissionjetpack.data.repository.DataRepository
import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenreResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesItem
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsResponse
import com.aldhykohar.submissionjetpack.utils.Resource
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException


/**
 * Created by aldhykohar on 5/11/2021.
 */
class MovieViewModel
@ViewModelInject
constructor(private val repository: DataRepository) : ViewModel() {

    fun getMovies() = repository.getMovies()
    fun getMoviesGenre() = repository.getGenreMovies()

}