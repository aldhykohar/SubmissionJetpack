package com.aldhykohar.submissionjetpack.ui.tvshow.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.aldhykohar.submissionjetpack.data.repository.DataRepository


/**
 * Created by aldhykohar on 5/11/2021.
 */
class DetailTvShowViewModel
@ViewModelInject
constructor(private val repository: DataRepository) : ViewModel() {

    fun getDetailTvShow(tvShowId: Int) = repository.getDetailTvShow(tvShowId)

}