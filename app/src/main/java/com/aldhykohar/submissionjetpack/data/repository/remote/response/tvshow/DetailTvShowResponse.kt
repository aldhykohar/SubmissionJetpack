package com.aldhykohar.submissionjetpack.data.repository.remote.response.tvshow

import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenresItem
import com.google.gson.annotations.SerializedName

data class DetailTvShowResponse(

    @field:SerializedName("first_air_date")
    val firstAirDate: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("original_language")
    val originalLanguage: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("backdrop_path")
    val backdropPath: String,

    @field:SerializedName("genres")
    val genres: List<GenresItem>,

    @field:SerializedName("original_name")
    val originalName: String,

    @field:SerializedName("popularity")
    val popularity: Double,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("in_production")
    val inProduction: Boolean,

    @field:SerializedName("last_air_date")
    val lastAirDate: String,

    @field:SerializedName("vote_count")
    val voteCount: Int
)
