package com.aldhykohar.submissionjetpack.ui.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.aldhykohar.submissionjetpack.data.repository.DataRepository


/**
 * Created by aldhykohar on 5/11/2021.
 */
class MovieViewModel
@ViewModelInject
constructor(private val repository: DataRepository) : ViewModel() {

    fun getMovies() = repository.getMovies()

}