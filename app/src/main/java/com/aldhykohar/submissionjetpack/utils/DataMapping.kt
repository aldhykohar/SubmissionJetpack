package com.aldhykohar.submissionjetpack.utils

import com.aldhykohar.submissionjetpack.data.repository.local.entity.DetailEntity
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.data.repository.local.entity.TvShowsEntity


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
                releaseDate,
                voteAverage
            )
        }
    }

    fun generateTvShow(data: DetailEntity): TvShowsEntity {
        with(data) {
            return TvShowsEntity(
                releaseDate,
                overview, posterPath, title, voteAverage, title, id
            )
        }
    }
}