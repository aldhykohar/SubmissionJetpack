package com.aldhykohar.submissionjetpack.ui.movie.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.aldhykohar.submissionjetpack.data.repository.DataRepository


/**
 * Created by aldhykohar on 5/11/2021.
 */
class DetailMovieViewModel
@ViewModelInject
constructor(private val repository: DataRepository) : ViewModel() {

    fun getDetailMovies(moviesId: Int) = repository.getDetailMovies(moviesId)

}