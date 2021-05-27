package com.aldhykohar.submissionjetpack.data.api

import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by aldhykohar on 5/26/2021.
 */
interface ApiService {

    @GET("movie/popular")
    fun getMovies(
    ): Call<MoviesResponse>
}