package com.aldhykohar.submissionjetpack.ui.movie

import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity


/**
 * Created by aldhykohar on 5/17/2021.
 */
interface MoviesListener {
    fun onItemMoviesClicked(movies: MovieEntity)
}