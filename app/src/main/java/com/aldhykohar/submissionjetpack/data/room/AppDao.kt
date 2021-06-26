package com.aldhykohar.submissionjetpack.data.room

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity


/**
 * Created by aldhykohar on 6/26/2021.
 */

@Dao
interface AppDao {

    @Query("SELECT * FROM tb_movie")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>
}