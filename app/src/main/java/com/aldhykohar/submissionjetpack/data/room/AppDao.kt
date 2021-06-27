package com.aldhykohar.submissionjetpack.data.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity


/**
 * Created by aldhykohar on 6/26/2021.
 */

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movie: MovieEntity)

    @Query("SELECT * FROM tb_movie")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>
}