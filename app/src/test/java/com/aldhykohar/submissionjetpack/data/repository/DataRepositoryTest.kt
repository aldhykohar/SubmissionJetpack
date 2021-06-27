package com.aldhykohar.submissionjetpack.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.aldhykohar.submissionjetpack.data.FakeRemoteRepository
import com.aldhykohar.submissionjetpack.data.repository.local.LocalRepository
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.data.repository.local.entity.TvShowsEntity
import com.aldhykohar.submissionjetpack.data.repository.remote.RemoteRepository
import com.aldhykohar.submissionjetpack.utils.DataDummy
import com.aldhykohar.submissionjetpack.utils.LiveDataTestUtil
import com.aldhykohar.submissionjetpack.utils.PagedListUtil
import com.aldhykohar.submissionjetpack.utils.Resource
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

/**
 * Created by aldhykohar on 5/30/2021.
 */

class DataRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val local = mock(LocalRepository::class.java)
    private val remote = mock(RemoteRepository::class.java)
    private val fakeRemoteRepository = FakeRemoteRepository(remote, local)

    private val moviesResponse = DataDummy.generateDummyMovies()
    private val movieId = moviesResponse[0].id
    private val moviesDetailResponse = DataDummy.generateDetailMoviesResponse()

    private val tvShowResponse = DataDummy.generateDummyTvShow()
    private val tvShowId = tvShowResponse[0].id
    private val tvShowDetailResponse = DataDummy.generateDetailTvShowResponse()


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
    fun getDetailMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteRepository.LoadDetailMovies).onDetailMoviesLoaded(
                moviesDetailResponse
            )
            null
        }.`when`(remote).getDetailMovies(any(), eq(movieId))

        val moviesDetail = LiveDataTestUtil.getValue(fakeRemoteRepository.getDetailMovies(movieId))
        verify(remote).getDetailMovies(any(), eq(movieId))
        assertNotNull(moviesDetail)
        assertEquals(moviesDetailResponse.id, moviesDetail.id)
    }

    @Test
    fun getDetailTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteRepository.LoadDetailTvShow).onDetailTvShowLoaded(
                tvShowDetailResponse
            )
            null
        }.`when`(remote).getDetailTvShow(any(), eq(tvShowId))

        val moviesDetail = LiveDataTestUtil.getValue(fakeRemoteRepository.getDetailTvShow(tvShowId))
        verify(remote).getDetailTvShow(any(), eq(tvShowId))
        assertNotNull(moviesDetail)
        assertEquals(tvShowDetailResponse.id, moviesDetail.id)
    }

    @Test
    fun getMovieFavorite() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        Mockito.`when`(local.getMovieFav()).thenReturn(dataSourceFactory)
        fakeRemoteRepository.getMovieFav()
        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMoviesEntities()))

        verify(local).getMovieFav()
        assertNotNull(movieEntities)
        assertEquals(moviesResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShowFavorite() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowsEntity>
        Mockito.`when`(local.getTvShowFav()).thenReturn(dataSourceFactory)
        fakeRemoteRepository.getTvShowFav()
        val tvShowEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShowEntities()))

        verify(local).getTvShowFav()
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }
}