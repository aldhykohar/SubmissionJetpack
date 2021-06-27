package com.aldhykohar.submissionjetpack.utils

import com.aldhykohar.submissionjetpack.data.model.DetailEntity
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.data.repository.local.entity.TvShowsEntity
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.MoviesItem


/**
 * Created by aldhykohar on 6/26/2021.
 */
object DataMapping {

    fun generateMovie(data: DetailEntity): MovieEntity {
        with(data) {
            return MovieEntity(
                id,
                overview,
                title,
                title,
                posterPath,
                backdropPath,
                releaseDate,
                voteAverage
            )
        }
    }

    fun generateTvShow(data: DetailEntity): TvShowsEntity {
        with(data) {
            return TvShowsEntity(
                releaseDate,
                overview, posterPath, title, voteAverage, title, id, voteCount
            )
        }
    }
}