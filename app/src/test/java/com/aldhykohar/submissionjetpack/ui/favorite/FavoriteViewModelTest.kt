package com.aldhykohar.submissionjetpack.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.aldhykohar.submissionjetpack.data.repository.DataRepository
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.data.repository.local.entity.TvShowsEntity
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by aldhykohar on 6/27/2021.
 */
@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observerMovie: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<PagedList<TvShowsEntity>>

    @Mock
    private lateinit var pagedListMovie: PagedList<MovieEntity>

    @Mock
    private lateinit var pagedListTvShow: PagedList<TvShowsEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(dataRepository)
    }

    @Test
    fun getFavoriteMovie() {
        val dummyMovie = pagedListMovie
        Mockito.`when`(dummyMovie.size).thenReturn(5)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyMovie

        Mockito.`when`(dataRepository.getMovieFav()).thenReturn(movies)
        val movieEntities = viewModel.getFavoriteMovie().value
        Mockito.verify(dataRepository).getMovieFav()
        assertNotNull(movieEntities)
        assertEquals(5, movieEntities?.size)

        viewModel.getFavoriteMovie().observeForever(observerMovie)
        Mockito.verify(observerMovie).onChanged(dummyMovie)
    }


    @Test
    fun getFavoriteTvSHow() {
        val dummyTvShow = pagedListTvShow
        Mockito.`when`(dummyTvShow.size).thenReturn(5)
        val tvShow = MutableLiveData<PagedList<TvShowsEntity>>()
        tvShow.value = dummyTvShow

        Mockito.`when`(dataRepository.getTvShowFav()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getFavoriteTvSHow().value
        Mockito.verify(dataRepository).getTvShowFav()
        assertNotNull(tvShowEntities)
        assertEquals(5, tvShowEntities?.size)

        viewModel.getFavoriteTvSHow().observeForever(observerTvShow)
        Mockito.verify(observerTvShow).onChanged(dummyTvShow)
    }
}