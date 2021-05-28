package com.aldhykohar.submissionjetpack.data.repository

import androidx.lifecycle.MutableLiveData
import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenreResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsResponse
import com.aldhykohar.submissionjetpack.utils.Resource


/**
 * Created by aldhykohar on 5/26/2021.
 */
interface Repository {
    suspend fun getMovies(): MutableLiveData<Resource<MoviesResponse>>
    suspend fun getGenreMovies(): MutableLiveData<Resource<GenreResponse>>
    suspend fun getTvShows(): MutableLiveData<Resource<TvShowsResponse>>
    suspend fun getGenreTvShow(): MutableLiveData<Resource<GenreResponse>>
}