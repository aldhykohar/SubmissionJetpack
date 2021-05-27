package com.aldhykohar.submissionjetpack.data.repository.remote

import androidx.lifecycle.MutableLiveData
import com.aldhykohar.submissionjetpack.data.api.ApiService
import com.aldhykohar.submissionjetpack.data.repository.Repository
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsResponse
import com.aldhykohar.submissionjetpack.utils.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


/**
 * Created by aldhykohar on 5/26/2021.
 */
class RemoteRepository
@Inject
constructor(private val apiService: ApiService) : Repository {
    override suspend fun getMovies(): MutableLiveData<Resource<MoviesResponse>> {
        val data = MutableLiveData<Resource<MoviesResponse>>()
        data.postValue(Resource.loading(null))
        apiService.getMovies().enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                if (response.isSuccessful) {
                    data.postValue(Resource.success(response.body()))
                } else {
                    data.postValue(Resource.error(response.message().toString(), null))
                }
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                data.postValue(Resource.error(t.message.toString(), null))

            }
        })
        return data

    }

    override suspend fun getTvShows(): MutableLiveData<Resource<TvShowsResponse>> {
        val data = MutableLiveData<Resource<TvShowsResponse>>()
        data.postValue(Resource.loading(null))
        apiService.getTvShows().enqueue(object : Callback<TvShowsResponse> {
            override fun onResponse(
                call: Call<TvShowsResponse>,
                response: Response<TvShowsResponse>
            ) {
                if (response.isSuccessful) {
                    data.postValue(Resource.success(response.body()))
                } else {
                    data.postValue(Resource.error(response.message().toString(), null))
                }
            }

            override fun onFailure(call: Call<TvShowsResponse>, t: Throwable) {
                data.postValue(Resource.error(t.message.toString(), null))
            }

        })
        return data
    }

}