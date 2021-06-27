package com.aldhykohar.submissionjetpack.data.repository.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull


/**
 * Created by aldhykohar on 6/27/2021.
 */
@Entity(tableName = "tb_genre")
data class GenreEntity(
    @ColumnInfo(name = "genre_name")
    val name: String,

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "id_genre")
    val id: Int
)