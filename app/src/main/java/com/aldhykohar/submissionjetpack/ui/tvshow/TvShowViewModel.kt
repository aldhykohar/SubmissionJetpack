package com.aldhykohar.submissionjetpack.ui.tvshow

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.aldhykohar.submissionjetpack.data.repository.DataRepository


/**
 * Created by aldhykohar on 5/11/2021.
 */
class TvShowViewModel
@ViewModelInject
constructor(private val repository: DataRepository) : ViewModel() {
    fun getTvShows() = repository.getTvShows()

}