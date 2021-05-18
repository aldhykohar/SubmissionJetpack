package com.aldhykohar.submissionjetpack.ui.movie

import androidx.lifecycle.ViewModel
import com.aldhykohar.submissionjetpack.data.model.MoviesModel
import com.aldhykohar.submissionjetpack.utils.DataDummy


/**
 * Created by aldhykohar on 5/11/2021.
 */
class MovieViewModel : ViewModel() {
    fun getMovie(): List<MoviesModel> = DataDummy.generateDummyMovie()
}