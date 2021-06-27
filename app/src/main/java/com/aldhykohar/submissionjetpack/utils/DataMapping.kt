package com.aldhykohar.submissionjetpack.utils

import com.aldhykohar.submissionjetpack.data.model.DetailEntity
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.MoviesItem


/**
 * Created by aldhykohar on 6/26/2021.
 */
object DataMapping {

    fun generateMovie(data: DetailEntity): MovieEntity {
        val genre = ArrayList<Int>()
        for (gn in data.genres) {
            genre.add(gn.id)
        }
        with(data) {
            return MovieEntity(
                id,
                overview,
                title,
                title,
                genre,
                posterPath,
                backdropPath,
                releaseDate,
                voteAverage
            )
        }
    }
}