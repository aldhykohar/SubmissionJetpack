package com.aldhykohar.submissionjetpack.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesResponse
import com.aldhykohar.submissionjetpack.utils.Resource


/**
 * Created by aldhykohar on 5/26/2021.
 */
interface Repository {
    suspend fun getMovies(): MutableLiveData<Resource<MoviesResponse>>
}