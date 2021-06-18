package com.aldhykohar.submissionjetpack.data.repository

import androidx.lifecycle.LiveData
import com.aldhykohar.submissionjetpack.data.model.DetailEntity
import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenresItem
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.MoviesItem
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsItem


/**
 * Created by aldhykohar on 5/26/2021.
 */
interface Repository {
    fun getMovies(): LiveData<List<MoviesItem>>
    fun getTvShows(): LiveData<List<TvShowsItem>>
    fun getGenreMovies(): LiveData<List<GenresItem>>
    fun getGenreTvShow(): LiveData<List<GenresItem>>
    fun getDetailMovies(moviesId: Int): LiveData<DetailEntity>
    fun getDetailTvShow(tvShowId: Int): LiveData<DetailEntity>
}