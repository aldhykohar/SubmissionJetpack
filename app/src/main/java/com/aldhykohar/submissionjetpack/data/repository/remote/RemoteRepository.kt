package com.aldhykohar.submissionjetpack.data.repository.remote

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aldhykohar.submissionjetpack.data.api.ApiService
import com.aldhykohar.submissionjetpack.data.repository.Repository
import com.aldhykohar.submissionjetpack.data.repository.remote.response.*
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
constructor(private val apiService: ApiService) {
    fun getMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        apiService.getMovies().enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                callback.onMoviesLoaded(response.body()?.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getGenreMovie(callback: LoadGenreCallback) {
        EspressoIdlingResource.increment()
        apiService.getGenreMovies().enqueue(object : Callback<GenreResponse> {
            override fun onResponse(
                call: Call<GenreResponse>,
                response: Response<GenreResponse>
            ) {
                callback.onGenreLoaded(response.body()?.genres)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<GenreResponse>, t: Throwable) {
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getTvShow(callback: LoadTvShowCallback) {
        EspressoIdlingResource.increment()
        apiService.getTvShows().enqueue(object : Callback<TvShowsResponse> {
            override fun onResponse(
                call: Call<TvShowsResponse>,
                response: Response<TvShowsResponse>
            ) {
                callback.onTvShowLoaded(response.body()?.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowsResponse>, t: Throwable) {
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getGenreTvShow(callback: LoadGenreCallback) {
        EspressoIdlingResource.increment()
        apiService.getGenreMovies().enqueue(object : Callback<GenreResponse> {
            override fun onResponse(
                call: Call<GenreResponse>,
                response: Response<GenreResponse>
            ) {
                callback.onGenreLoaded(response.body()?.genres)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<GenreResponse>, t: Throwable) {
                EspressoIdlingResource.decrement()
            }
        })
    }

    interface LoadMoviesCallback {
        fun onMoviesLoaded(movies: List<MoviesItem>?)
    }

    interface LoadGenreCallback {
        fun onGenreLoaded(genres: List<GenresItem>?)
    }

    interface LoadTvShowCallback {
        fun onTvShowLoaded(tvShow: List<TvShowsItem>?)
    }

}