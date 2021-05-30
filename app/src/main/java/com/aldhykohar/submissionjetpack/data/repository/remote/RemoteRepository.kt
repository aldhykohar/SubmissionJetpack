package com.aldhykohar.submissionjetpack.data.repository.remote

import androidx.lifecycle.MutableLiveData
import com.aldhykohar.submissionjetpack.data.api.ApiService
import com.aldhykohar.submissionjetpack.data.repository.Repository
import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenreResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsResponse
import com.aldhykohar.submissionjetpack.utils.EspressoIdlingResource
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
        EspressoIdlingResource.increment()
        val data = MutableLiveData<Resource<MoviesResponse>>()
        data.postValue(Resource.loading(null))
        apiService.getMovies().enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                EspressoIdlingResource.decrement()
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

    override suspend fun getGenreMovies(): MutableLiveData<Resource<GenreResponse>> {
        EspressoIdlingResource.increment()
        val data = MutableLiveData<Resource<GenreResponse>>()
        data.postValue(Resource.loading(null))
        apiService.getGenreMovies().enqueue(object : Callback<GenreResponse> {
            override fun onResponse(
                call: Call<GenreResponse>,
                response: Response<GenreResponse>
            ) {
                EspressoIdlingResource.decrement()
                if (response.isSuccessful) {
                    data.postValue(Resource.success(response.body()))
                } else {
                    data.postValue(Resource.error(response.message().toString(), null))
                }
            }

            override fun onFailure(call: Call<GenreResponse>, t: Throwable) {
                data.postValue(Resource.error(t.message.toString(), null))

            }
        })
        return data
    }

    override suspend fun getTvShows(): MutableLiveData<Resource<TvShowsResponse>> {
        EspressoIdlingResource.increment()
        val data = MutableLiveData<Resource<TvShowsResponse>>()
        data.postValue(Resource.loading(null))
        apiService.getTvShows().enqueue(object : Callback<TvShowsResponse> {
            override fun onResponse(
                call: Call<TvShowsResponse>,
                response: Response<TvShowsResponse>
            ) {
                EspressoIdlingResource.decrement()
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

    override suspend fun getGenreTvShow(): MutableLiveData<Resource<GenreResponse>> {
        EspressoIdlingResource.increment()
        val data = MutableLiveData<Resource<GenreResponse>>()
        data.postValue(Resource.loading(null))
        apiService.getGenreTvShow().enqueue(object : Callback<GenreResponse> {
            override fun onResponse(
                call: Call<GenreResponse>,
                response: Response<GenreResponse>
            ) {
                EspressoIdlingResource.decrement()
                if (response.isSuccessful) {
                    data.postValue(Resource.success(response.body()))
                } else {
                    data.postValue(Resource.error(response.message().toString(), null))
                }
            }

            override fun onFailure(call: Call<GenreResponse>, t: Throwable) {
                data.postValue(Resource.error(t.message.toString(), null))

            }
        })
        return data
    }


}