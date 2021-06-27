package com.aldhykohar.submissionjetpack.ui.movie

import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.MoviesItem


/**
 * Created by aldhykohar on 5/17/2021.
 */
interface MoviesListener {
    fun onItemMoviesClicked(movies: MovieEntity, genre: String)
}