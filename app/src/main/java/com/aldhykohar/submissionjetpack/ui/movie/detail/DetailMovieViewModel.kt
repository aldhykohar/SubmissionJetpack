package com.aldhykohar.submissionjetpack.ui.movie.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldhykohar.submissionjetpack.data.repository.DataRepository
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import kotlinx.coroutines.launch


/**
 * Created by aldhykohar on 5/11/2021.
 */
class DetailMovieViewModel
@ViewModelInject
constructor(private val repository: DataRepository) : ViewModel() {

    fun getDetailMovies(moviesId: Int) = repository.getDetailMovies(moviesId)

    fun setFavorite(movie: MovieEntity) {
        viewModelScope.launch {
            repository.setMovieFav(movie)
        }
    }

}