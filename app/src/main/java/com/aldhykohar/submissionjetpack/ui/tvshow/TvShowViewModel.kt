package com.aldhykohar.submissionjetpack.ui.tvshow

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldhykohar.submissionjetpack.data.model.MoviesModel
import com.aldhykohar.submissionjetpack.data.repository.DataRepository
import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenreResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsResponse
import com.aldhykohar.submissionjetpack.utils.DataDummy
import com.aldhykohar.submissionjetpack.utils.Resource
import kotlinx.coroutines.launch


/**
 * Created by aldhykohar on 5/11/2021.
 */
class TvShowViewModel
@ViewModelInject
constructor(private val repository: DataRepository) : ViewModel() {
    fun getTvShow(): List<MoviesModel> = DataDummy.generateDummyTvShow()

    fun getTvShows(): LiveData<Resource<TvShowsResponse>> {
        var data = MutableLiveData<Resource<TvShowsResponse>>()
        viewModelScope.launch {
            data = repository.getTvShows()
        }
        return data
    }

    fun getGenreTvShow(): LiveData<Resource<GenreResponse>> {
        var data = MutableLiveData<Resource<GenreResponse>>()
        viewModelScope.launch {
            data = repository.getGenreTvShow()
        }
        return data
    }
}