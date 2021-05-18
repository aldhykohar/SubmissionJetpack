package com.aldhykohar.submissionjetpack.data.model


/**
 * Created by aldhykohar on 5/11/2021.
 */
data class MoviesModel(
    var moviesId: String,
    var title: String,
    var imgPath: Int,
    var rate: String,
    var date: String,
    var genre: String,
    var desc: String,
    var duration: String,
    var country: String
)