package com.aldhykohar.submissionjetpack.data.repository.local

import androidx.paging.DataSource
import com.aldhykohar.submissionjetpack.data.repository.local.entity.GenreEntity
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenresItem
import com.aldhykohar.submissionjetpack.data.room.AppDao
import javax.inject.Inject


/**
 * Created by aldhykohar on 6/26/2021.
 */
class LocalRepository
@Inject constructor(private val appDao: AppDao) {

    suspend fun insertMovieFav(movies: MovieEntity) = appDao.insertMovies(movies)
    fun getMovieFav(): DataSource.Factory<Int, MovieEntity> = appDao.getMovies()
    fun insertGenre(genre: List<GenreEntity>) = appDao.insertGenre(genre)
    fun getAllGenre() = appDao.getAllGenre()
}