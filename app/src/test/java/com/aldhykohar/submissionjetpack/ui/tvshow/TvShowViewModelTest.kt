package com.aldhykohar.submissionjetpack.ui.tvshow

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by aldhykohar on 5/17/2021.
 */
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShow() {
        val tvShowEntities = viewModel.getTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities.size)
    }
}