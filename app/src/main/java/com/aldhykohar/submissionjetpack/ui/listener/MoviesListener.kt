package com.aldhykohar.submissionjetpack.ui.listener

import com.aldhykohar.submissionjetpack.data.model.MoviesModel


/**
 * Created by aldhykohar on 5/17/2021.
 */
interface MoviesListener {
    fun onItemMoviesClicked(movies: MoviesModel)
}