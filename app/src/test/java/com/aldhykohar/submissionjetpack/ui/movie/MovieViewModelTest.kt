package com.aldhykohar.submissionjetpack.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aldhykohar.submissionjetpack.data.repository.DataRepository
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by aldhykohar on 6/17/2021.
 */
@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observerMovie: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(dataRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.generateDummyMoviesEntities()
        val movies = MutableLiveData<List<MovieEntity>>()
        movies.value = dummyMovies

        `when`(dataRepository.getMovies()).thenReturn(movies)
        val movie = viewModel.getMovies().value
        verify(dataRepository).getMovies()
        assertNotNull(movie)
        assertEquals(dummyMovies.size, movie?.size)

        viewModel.getMovies().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovies)
    }
}