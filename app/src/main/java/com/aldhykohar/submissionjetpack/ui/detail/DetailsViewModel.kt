package com.aldhykohar.submissionjetpack.ui.detail

import androidx.lifecycle.ViewModel
import com.aldhykohar.submissionjetpack.data.model.MoviesModel
import com.aldhykohar.submissionjetpack.utils.DataDummy


/**
 * Created by aldhykohar on 5/17/2021.
 */
class DetailsViewModel : ViewModel() {

    private lateinit var moviesId: String

    fun setSelectedMovies(moviesId: String) {
        this.moviesId = moviesId
    }

    fun getMovies(): MoviesModel {
        lateinit var movies: MoviesModel
        val moviesEntities = DataDummy.generateDummyMovie()
        for (moviesEntity in moviesEntities) {
            if (moviesEntity.moviesId == moviesId) {
                movies = moviesEntity
            }
        }
        return movies
    }

    fun getTvShow(): MoviesModel {
        lateinit var tvshow: MoviesModel
        val tvShowEntities = DataDummy.generateDummyTvShow()
        for (tvShowEntity in tvShowEntities) {
            if (tvShowEntity.moviesId == moviesId) {
                tvshow = tvShowEntity
            }
        }
        return tvshow
    }
}