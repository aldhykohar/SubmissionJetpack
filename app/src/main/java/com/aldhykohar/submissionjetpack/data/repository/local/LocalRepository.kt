package com.aldhykohar.submissionjetpack.data.repository.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.data.repository.local.entity.TvShowsEntity
import com.aldhykohar.submissionjetpack.data.room.AppDao
import javax.inject.Inject


/**
 * Created by aldhykohar on 6/26/2021.
 */
class LocalRepository
@Inject constructor(private val appDao: AppDao) {

    suspend fun insertMovieFav(movies: MovieEntity) = appDao.insertMovies(movies)
    suspend fun deleteMovieFav(movies: MovieEntity) = appDao.deleteMovie(movies)
    fun getMovieFav(): DataSource.Factory<Int, MovieEntity> = appDao.getMovies()
    fun checkMovieFav(movieId: Int): LiveData<MovieEntity> = appDao.checkMovieFav(movieId)
    suspend fun insertTvShowFav(tvShows: TvShowsEntity) = appDao.insertTvShow(tvShows)
    suspend fun deleteTvShow(tvShows: TvShowsEntity) = appDao.deleteTvShow(tvShows)
    fun getTvShowFav(): DataSource.Factory<Int, TvShowsEntity> = appDao.getTvShow()
    fun checkTvShowFav(tvShowId: Int): LiveData<TvShowsEntity> = appDao.checkTvShowFav(tvShowId)
}