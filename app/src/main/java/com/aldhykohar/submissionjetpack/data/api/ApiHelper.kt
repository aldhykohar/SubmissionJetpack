package com.aldhykohar.submissionjetpack.data.api

import com.aldhykohar.submissionjetpack.data.repository.remote.response.DetailTvShowResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.DetailMovieResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenreResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.MoviesResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsResponse
import retrofit2.Call


/**
 * Created by aldhykohar on 5/26/2021.
 */
interface ApiHelper {
    suspend fun getMovies(): Call<MoviesResponse>
    suspend fun getGenreMovies(): Call<GenreResponse>
    suspend fun getTvShows(): Call<TvShowsResponse>
    suspend fun getGenreTvShow(): Call<GenreResponse>
    suspend fun getDetailMovies(moviesId: Int): Call<DetailMovieResponse>
    suspend fun getTvShowMovies(tvShowId: Int): Call<DetailTvShowResponse>
}