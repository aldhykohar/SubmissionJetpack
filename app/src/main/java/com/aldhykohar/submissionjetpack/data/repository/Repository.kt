package com.aldhykohar.submissionjetpack.data.repository

import androidx.lifecycle.LiveData
import com.aldhykohar.submissionjetpack.data.repository.local.entity.DetailEntity
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.data.repository.local.entity.TvShowsEntity


/**
 * Created by aldhykohar on 5/26/2021.
 */
interface Repository {
    fun getMovies(): LiveData<List<MovieEntity>>
    fun getTvShows(): LiveData<List<TvShowsEntity>>
    fun getDetailMovies(moviesId: Int): LiveData<DetailEntity>
    fun getDetailTvShow(tvShowId: Int): LiveData<DetailEntity>
}