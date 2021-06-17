package com.aldhykohar.submissionjetpack.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aldhykohar.submissionjetpack.data.repository.remote.RemoteRepository
import com.aldhykohar.submissionjetpack.data.repository.remote.response.*
import com.aldhykohar.submissionjetpack.utils.Resource
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by aldhykohar on 5/26/2021.
 */
interface Repository {
    fun getMovies(): LiveData<List<MoviesItem>>
    fun getTvShows(): LiveData<List<TvShowsItem>>
    fun getGenreMovies(): LiveData<List<GenresItem>>
    fun getGenreTvShow(): LiveData<List<GenresItem>>
}