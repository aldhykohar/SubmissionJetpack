package com.aldhykohar.submissionjetpack.data.api

import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenreResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by aldhykohar on 5/26/2021.
 */
interface ApiService {

    @GET("movie/popular")
    fun getMovies(
    ): Call<MoviesResponse>

    @GET("genre/movie/list")
    fun getGenreMovies(
    ): Call<GenreResponse>

    @GET("tv/popular")
    fun getTvShows(
    ): Call<TvShowsResponse>

    @GET("genre/tv/list")
    fun getGenreTvShow(
    ): Call<GenreResponse>

}