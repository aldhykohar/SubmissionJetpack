package com.aldhykohar.submissionjetpack.data.repository.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aldhykohar.submissionjetpack.data.api.ApiService
import com.aldhykohar.submissionjetpack.data.repository.remote.response.*
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.DetailMovieResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.MoviesItem
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.MoviesResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.tvshow.DetailTvShowResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.tvshow.TvShowsItem
import com.aldhykohar.submissionjetpack.data.repository.remote.response.tvshow.TvShowsResponse
import com.aldhykohar.submissionjetpack.utils.EspressoIdlingResource
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

    fun getGenreMovie(): LiveData<ApiResponse<List<GenresItem>>> {
        EspressoIdlingResource.increment()
        val data = MutableLiveData<ApiResponse<List<GenresItem>>>()
        apiService.getGenreMovies().enqueue(object : Callback<GenreResponse> {
            override fun onResponse(
                call: Call<GenreResponse>,
                response: Response<GenreResponse>
            ) {
                data.value = ApiResponse.success(response.body()?.genres!!)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<GenreResponse>, t: Throwable) {
                EspressoIdlingResource.decrement()
            }
        })
        return data
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

    fun getDetailMovies(callback: LoadDetailMovies, moviesId: Int) {
        EspressoIdlingResource.increment()
        apiService.getDetailMovie(moviesId).enqueue(object : Callback<DetailMovieResponse> {
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {
                callback.onDetailMoviesLoaded(response.body())
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                EspressoIdlingResource.decrement()
            }

        })
    }

    fun getDetailTvShow(callback: LoadDetailTvShow, moviesId: Int) {
        EspressoIdlingResource.increment()
        apiService.getDetailTvShow(moviesId).enqueue(object : Callback<DetailTvShowResponse> {
            override fun onResponse(
                call: Call<DetailTvShowResponse>,
                response: Response<DetailTvShowResponse>
            ) {
                callback.onDetailTvShowLoaded(response.body())
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DetailTvShowResponse>, t: Throwable) {
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

    interface LoadDetailMovies {
        fun onDetailMoviesLoaded(details: DetailMovieResponse?)
    }

    interface LoadDetailTvShow {
        fun onDetailTvShowLoaded(details: DetailTvShowResponse?)
    }

}