package com.aldhykohar.submissionjetpack.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aldhykohar.submissionjetpack.data.FakeRemoteRepository
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by aldhykohar on 5/30/2021.
 */

@RunWith(MockitoJUnitRunner::class)
class DataRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var fakeRemoteRepository: FakeRemoteRepository

    @Before
    fun setUp() {
        fakeRemoteRepository = FakeRemoteRepository()

    }

    @Test
    fun getMovies() {
        val res = fakeRemoteRepository.getMovies().execute()
        assertEquals(200, res.code())
        assertNotNull(res.body()?.results)
        assertEquals(20, res.body()?.results?.size)
    }

    @Test
    fun getGenreMovies() {
        val res = fakeRemoteRepository.getGenreMovies().execute()
        assertEquals(200, res.code())
        assertNotNull(res.body()?.genres)
    }

    @Test
    fun getTvShows() {
        val res = fakeRemoteRepository.getTvShows().execute()
        assertEquals(200, res.code())
        assertNotNull(res.body()?.results)
        assertEquals(20, res.body()?.results?.size)
    }

    @Test
    fun getGenreTvShow() {
        val res = fakeRemoteRepository.getGenreTvShow().execute()
        assertEquals(200, res.code())
        assertNotNull(res.body()?.genres)
    }
}