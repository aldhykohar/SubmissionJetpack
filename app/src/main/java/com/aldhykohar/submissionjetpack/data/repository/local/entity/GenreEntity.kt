package com.aldhykohar.submissionjetpack.data.repository.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName


/**
 * Created by aldhykohar on 6/27/2021.
 */
@Entity(tableName = "tb_genre")
data class GenreEntity(
    @ColumnInfo(name = "genre_name")
    val name: String,

    @ColumnInfo(name = "id_genre")
    val id: Int
)