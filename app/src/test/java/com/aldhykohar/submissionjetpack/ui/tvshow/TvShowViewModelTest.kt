package com.aldhykohar.submissionjetpack.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aldhykohar.submissionjetpack.data.repository.DataRepository
import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenresItem
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsItem
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
 * Created by aldhykohar on 6/17/2021.
 */
@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observerTvShow: Observer<List<TvShowsItem>>

    @Mock
    private lateinit var observerGenre: Observer<List<GenresItem>>


    @Before
    fun setUp() {
        viewModel = TvShowViewModel(dataRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShow = DataDummy.generateDummyTvShow()
        val tvShows = MutableLiveData<List<TvShowsItem>>()
        tvShows.value = dummyTvShow

        Mockito.`when`(dataRepository.getTvShows()).thenReturn(tvShows)
        val tvShow = viewModel.getTvShows().value
        verify(dataRepository).getTvShows()
        assertNotNull(tvShow)
        assertEquals(1, tvShow?.size)

        viewModel.getTvShows().observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)

    }

    @Test
    fun getTvShowGenre() {
        val dummyGenre = DataDummy.generateDummyGenreTvShows()
        val genres = MutableLiveData<List<GenresItem>>()
        genres.value = dummyGenre

        Mockito.`when`(dataRepository.getGenreTvShow()).thenReturn(genres)
        val genre = viewModel.getTvShowGenre().value
        verify(dataRepository).getGenreTvShow()

        assertNotNull(genre)
        assertEquals(1, genre?.size)

        viewModel.getTvShowGenre().observeForever(observerGenre)
        verify(observerGenre).onChanged(dummyGenre)
    }
}