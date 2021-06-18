package com.aldhykohar.submissionjetpack.ui.tvshow.detail

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
class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel

    private val dummyTvShow = DataDummy.generateDummyDetailTvShow()
    private val dummyTvShowId = dummyTvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var tvShowObserver: Observer<DetailEntity>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(dataRepository)
    }

    @Test
    fun getDetailTvShow() {
        val tvShow = MutableLiveData<DetailEntity>()
        tvShow.value = dummyTvShow

        Mockito.`when`(dataRepository.getDetailTvShow(dummyTvShowId)).thenReturn(tvShow)
        val tvShows = viewModel.getDetailTvShow(dummyTvShowId).value
        verify(dataRepository).getDetailTvShow(dummyTvShowId)
        assertNotNull(tvShows)
        assertEquals(dummyTvShowId, tvShows?.id)

        viewModel.getDetailTvShow(dummyTvShowId).observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }
}