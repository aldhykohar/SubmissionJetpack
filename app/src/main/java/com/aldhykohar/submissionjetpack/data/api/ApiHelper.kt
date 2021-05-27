package com.aldhykohar.submissionjetpack.data.api

import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsResponse
import retrofit2.Call


/**
 * Created by aldhykohar on 5/26/2021.
 */
interface ApiHelper {
    suspend fun getMovies(): Call<MoviesResponse>
    suspend fun getTvShows(): Call<TvShowsResponse>
}