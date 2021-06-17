package com.aldhykohar.submissionjetpack.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aldhykohar.submissionjetpack.data.FakeRemoteRepository
import com.aldhykohar.submissionjetpack.data.repository.remote.RemoteRepository
import com.aldhykohar.submissionjetpack.utils.DataDummy
import com.aldhykohar.submissionjetpack.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

/**
 * Created by aldhykohar on 5/30/2021.
 */

class DataRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteRepository::class.java)
    private val fakeRemoteRepository = FakeRemoteRepository(remote)

    private val moviesResponse = DataDummy.generateDummyMovies()
    private val tvShowResponse = DataDummy.generateDummyTvShow()
    private val genreMoviesResponse = DataDummy.generateDummyGenreMovies()
    private val genreTvShowResponse = DataDummy.generateDummyGenreTvShows()

    @Test
    fun getMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteRepository.LoadMoviesCallback).onMoviesLoaded(
                moviesResponse
            )
            null
        }.`when`(remote).getMovies(any())

        val movieEntities = LiveDataTestUtil.getValue(fakeRemoteRepository.getMovies())
        verify(remote).getMovies(any())
        assertNotNull(movieEntities)
        assertEquals(moviesResponse.size, movieEntities.size)
    }

    @Test
    fun getTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteRepository.LoadTvShowCallback).onTvShowLoaded(
                tvShowResponse
            )
            null
        }.`when`(remote).getTvShow(any())

        val tvShowEntities = LiveDataTestUtil.getValue(fakeRemoteRepository.getTvShows())
        verify(remote).getTvShow(any())
        assertNotNull(tvShowEntities)
        assertEquals(moviesResponse.size, tvShowEntities.size)
    }

    @Test
    fun getGenreMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteRepository.LoadGenreCallback).onGenreLoaded(
                genreMoviesResponse
            )
            null
        }.`when`(remote).getGenreMovie(any())

        val genreEntities = LiveDataTestUtil.getValue(fakeRemoteRepository.getGenreMovies())
        verify(remote).getGenreMovie(any())
        assertNotNull(genreEntities)
        assertEquals(genreMoviesResponse.size, genreEntities.size)
    }

    @Test
    fun getGenreTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteRepository.LoadGenreCallback).onGenreLoaded(
                genreTvShowResponse
            )
            null
        }.`when`(remote).getGenreTvShow(any())

        val genreEntities = LiveDataTestUtil.getValue(fakeRemoteRepository.getGenreTvShow())
        verify(remote).getGenreTvShow(any())
        assertNotNull(genreEntities)
        assertEquals(genreTvShowResponse.size, genreEntities.size)
    }
}