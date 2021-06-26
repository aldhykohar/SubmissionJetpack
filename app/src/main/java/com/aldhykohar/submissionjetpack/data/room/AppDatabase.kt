package com.aldhykohar.submissionjetpack.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity


/**
 * Created by aldhykohar on 6/26/2021.
 */
@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): AppDao
}