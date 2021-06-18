package com.aldhykohar.submissionjetpack.ui.movie.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aldhykohar.submissionjetpack.data.model.DetailEntity
import com.aldhykohar.submissionjetpack.data.repository.DataRepository
import com.aldhykohar.submissionjetpack.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by aldhykohar on 6/18/2021.
 */

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel

    private val dummyMovie = DataDummy.generateDummyDetailMovies()
    private val dummyMovieId = dummyMovie.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var movieObserver: Observer<DetailEntity>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(dataRepository)
    }

    @Test
    fun getDetailMovies() {
        val movies = MutableLiveData<DetailEntity>()
        movies.value = dummyMovie

        Mockito.`when`(dataRepository.getDetailMovies(dummyMovieId)).thenReturn(movies)
        val movie = viewModel.getDetailMovies(dummyMovieId).value
        verify(dataRepository).getDetailMovies(dummyMovieId)
        assertNotNull(movie)
        assertEquals(dummyMovieId, movie?.id)

        viewModel.getDetailMovies(dummyMovieId).observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }
}