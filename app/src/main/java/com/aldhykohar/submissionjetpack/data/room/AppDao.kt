package com.aldhykohar.submissionjetpack.data.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.room.*
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.data.repository.local.entity.TvShowsEntity


/**
 * Created by aldhykohar on 6/26/2021.
 */

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movie: MovieEntity)

    @Query("SELECT * FROM tb_movie")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tb_movie WHERE movieId = :movieId")
    fun checkMovieFav(movieId: Int): LiveData<MovieEntity>

    @Delete
    suspend fun deleteMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShow(movie: TvShowsEntity)

    @Query("SELECT * FROM tb_tvshow")
    fun getTvShow(): DataSource.Factory<Int, TvShowsEntity>

    @Query("SELECT * FROM tb_tvshow WHERE id_tvshow = :tvShowId")
    fun checkTvShowFav(tvShowId: Int): LiveData<TvShowsEntity>

    @Delete
    suspend fun deleteTvShow(movie: TvShowsEntity)

}