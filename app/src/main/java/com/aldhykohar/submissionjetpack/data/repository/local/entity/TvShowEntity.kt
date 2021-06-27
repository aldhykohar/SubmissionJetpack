package com.aldhykohar.submissionjetpack.data.repository.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


/**
 * Created by aldhykohar on 6/27/2021.
 */

@Entity(tableName = "tb_tvshow")
data class TvShowsEntity(

    @ColumnInfo(name = "first_air_date")
    val firstAirDate: String,

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "poster_path")
    val posterPath: String,

    @ColumnInfo(name = "original_name")
    val originalName: String,

    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,

    @ColumnInfo(name = "name")
    val name: String,

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "id_tvshow")
    val id: Int,

    @ColumnInfo(name = "vote_count")
    val voteCount: Int
)