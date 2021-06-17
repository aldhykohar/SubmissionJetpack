package com.aldhykohar.submissionjetpack.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aldhykohar.submissionjetpack.data.repository.DataRepository
import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenresItem
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesItem
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
    private lateinit var observerMovie: Observer<List<MoviesItem>>

    @Mock
    private lateinit var observerGenre: Observer<List<GenresItem>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(dataRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.generateDummyMovies()
        val movies = MutableLiveData<List<MoviesItem>>()
        movies.value = dummyMovies

        `when`(dataRepository.getMovies()).thenReturn(movies)
        val movie = viewModel.getMovies().value
        verify(dataRepository).getMovies()
        assertNotNull(movie)
        assertEquals(1, movie?.size)

        viewModel.getMovies().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovies)
    }

    @Test
    fun getMoviesGenre() {
        val dummyGenre = DataDummy.generateDummyGenreMovies()
        val genres = MutableLiveData<List<GenresItem>>()
        genres.value = dummyGenre

        `when`(dataRepository.getGenreMovies()).thenReturn(genres)
        val genre = viewModel.getMoviesGenre().value
        verify(dataRepository).getGenreMovies()
        assertNotNull(genre)
        assertEquals(1, genre?.size)

        viewModel.getMoviesGenre().observeForever(observerGenre)
        verify(observerGenre).onChanged(dummyGenre)
    }
}