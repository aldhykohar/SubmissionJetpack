package com.aldhykohar.submissionjetpack.data.api

import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenreResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsResponse
import retrofit2.Call
import javax.inject.Inject


/**
 * Created by aldhykohar on 5/26/2021.
 */
class ApiHelperImpl
@Inject
constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getMovies(): Call<MoviesResponse> = apiService.getMovies()
    override suspend fun getGenreMovies(): Call<GenreResponse> = apiService.getGenreMovies()
    override suspend fun getTvShows(): Call<TvShowsResponse> = apiService.getTvShows()
    override suspend fun getGenreTvShow(): Call<GenreResponse> = apiService.getGenreTvShow()

}