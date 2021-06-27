package com.aldhykohar.submissionjetpack.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aldhykohar.submissionjetpack.data.repository.DataRepository
import com.aldhykohar.submissionjetpack.data.repository.local.entity.TvShowsEntity
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
    private lateinit var observerTvShow: Observer<List<TvShowsEntity>>


    @Before
    fun setUp() {
        viewModel = TvShowViewModel(dataRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShow = DataDummy.generateDummyTvShowEntities()
        val tvShows = MutableLiveData<List<TvShowsEntity>>()
        tvShows.value = dummyTvShow

        Mockito.`when`(dataRepository.getTvShows()).thenReturn(tvShows)
        val tvShow = viewModel.getTvShows().value
        verify(dataRepository).getTvShows()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.size, tvShow?.size)

        viewModel.getTvShows().observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)

    }
}