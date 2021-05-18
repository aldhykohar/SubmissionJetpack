package com.aldhykohar.submissionjetpack.ui.tvshow

import androidx.lifecycle.ViewModel
import com.aldhykohar.submissionjetpack.data.model.MoviesModel
import com.aldhykohar.submissionjetpack.utils.DataDummy


/**
 * Created by aldhykohar on 5/11/2021.
 */
class TvShowViewModel : ViewModel() {
    fun getTvShow(): List<MoviesModel> = DataDummy.generateDummyTvShow()
}