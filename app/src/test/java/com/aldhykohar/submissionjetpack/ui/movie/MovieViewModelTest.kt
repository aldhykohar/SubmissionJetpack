package com.aldhykohar.submissionjetpack.ui.movie

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

/**
 * Created by aldhykohar on 5/17/2021.
 */
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovie() {
        val movieEntities = viewModel.getMovie()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }
}