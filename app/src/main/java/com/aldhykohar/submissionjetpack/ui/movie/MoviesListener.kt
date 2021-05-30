package com.aldhykohar.submissionjetpack.ui.movie

import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesItem


/**
 * Created by aldhykohar on 5/17/2021.
 */
interface MoviesListener {
    fun onItemMoviesClicked(movies: MoviesItem, genre: String)
}