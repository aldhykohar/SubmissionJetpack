package com.aldhykohar.submissionjetpack.data.api

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

    override suspend fun getTvShows(): Call<TvShowsResponse> = apiService.getTvShows()

}