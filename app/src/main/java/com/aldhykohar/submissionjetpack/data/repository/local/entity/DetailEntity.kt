package com.aldhykohar.submissionjetpack.data.repository.local.entity

import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenresItem
import com.google.gson.annotations.SerializedName


/**
 * Created by aldhykohar on 6/18/2021.
 */
data class DetailEntity(
    @field:SerializedName("backdrop_path")
    val backdropPath: String,
    @field:SerializedName("genres")
    val genres: List<GenresItem>,
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("overview")
    val overview: String,
    @field:SerializedName("poster_path")
    val posterPath: String,
    @field:SerializedName("release_date")
    val releaseDate: String,
    @field:SerializedName("status")
    val status: String,
    @field:SerializedName("title")
    val title: String,
    @field:SerializedName("vote_average")
    val voteAverage: Double,
    @field:SerializedName("vote_count")
    val voteCount: Int
)