package com.aldhykohar.submissionjetpack.ui.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldhykohar.submissionjetpack.data.model.MoviesModel
import com.aldhykohar.submissionjetpack.data.repository.DataRepository
import com.aldhykohar.submissionjetpack.data.repository.Repository
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesResponse
import com.aldhykohar.submissionjetpack.utils.DataDummy
import com.aldhykohar.submissionjetpack.utils.Resource
import kotlinx.coroutines.launch


/**
 * Created by aldhykohar on 5/11/2021.
 */
class MovieViewModel
@ViewModelInject
constructor(private val repository: DataRepository) : ViewModel() {
    fun getMovie(): List<MoviesModel> = DataDummy.generateDummyMovie()

    fun getMovies(): LiveData<Resource<MoviesResponse>> {
        var data = MutableLiveData<Resource<MoviesResponse>>()
        viewModelScope.launch {
            data = repository.getMovies()
        }
        return data
    }
}