package com.aldhykohar.submissionjetpack.data.api

import com.aldhykohar.submissionjetpack.data.repository.remote.response.tvshow.DetailTvShowResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.DetailMovieResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenreResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.MoviesResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.tvshow.TvShowsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by aldhykohar on 5/26/2021.
 */
interface ApiService {

    @GET("movie/popular")
    fun getMovies(
    ): Call<MoviesResponse>

    @GET("tv/popular")
    fun getTvShows(
    ): Call<TvShowsResponse>

    @GET("movie/{movieId}")
    fun getDetailMovie(
        @Path("movieId") movieId: Int
    ): Call<DetailMovieResponse>

    @GET("tv/{tvShowId}")
    fun getDetailTvShow(
        @Path("tvShowId") tvShowId: Int
    ): Call<DetailTvShowResponse>

}