package com.aldhykohar.submissionjetpack.data.repository

import androidx.lifecycle.MutableLiveData
import com.aldhykohar.submissionjetpack.data.repository.remote.RemoteRepository
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsResponse
import com.aldhykohar.submissionjetpack.utils.Resource
import javax.inject.Inject


/**
 * Created by aldhykohar on 5/26/2021.
 */
class DataRepository
@Inject
constructor(private val remoteRepository: RemoteRepository) : Repository {
    override suspend fun getMovies(): MutableLiveData<Resource<MoviesResponse>> =
        remoteRepository.getMovies()

    override suspend fun getTvShows(): MutableLiveData<Resource<TvShowsResponse>> =
        remoteRepository.getTvShows()


}