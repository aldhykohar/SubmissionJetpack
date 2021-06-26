package com.aldhykohar.submissionjetpack.data.repository.local

import androidx.paging.DataSource
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.data.room.AppDao
import javax.inject.Inject


/**
 * Created by aldhykohar on 6/26/2021.
 */
class LocalRepository
@Inject constructor(private val appDao: AppDao) {

    fun getMovies(): DataSource.Factory<Int, MovieEntity> = appDao.getMovies()
}