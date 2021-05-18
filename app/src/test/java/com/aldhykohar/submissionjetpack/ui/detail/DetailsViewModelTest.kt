package com.aldhykohar.submissionjetpack.ui.detail

import com.aldhykohar.submissionjetpack.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

/**
 * Created by aldhykohar on 5/17/2021.
 */
class DetailsViewModelTest {

    private lateinit var viewModel: DetailsViewModel
    private val dummyMovies = DataDummy.generateDummyMovie()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val movieId = dummyMovies.moviesId
    private val tvShowId = dummyTvShow.moviesId

    @Before
    fun setUp() {
        viewModel = DetailsViewModel()
    }

    @Test
    fun getMovies() {
        viewModel.setSelectedMovies(movieId)
        val moviesEntity = viewModel.getMovies()
        assertNotNull(moviesEntity)
        assertEquals(dummyMovies.moviesId, moviesEntity.moviesId)
        assertEquals(dummyMovies.title, moviesEntity.title)
        assertEquals(dummyMovies.imgPath, moviesEntity.imgPath)
        assertEquals(dummyMovies.country, moviesEntity.country)
        assertEquals(dummyMovies.date, moviesEntity.date)
        assertEquals(dummyMovies.desc, moviesEntity.desc)
        assertEquals(dummyMovies.genre, moviesEntity.genre)
        assertEquals(dummyMovies.duration, moviesEntity.duration)
        assertEquals(dummyMovies.rate, moviesEntity.rate)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedMovies(tvShowId)
        val tvShowEntity = viewModel.getTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.moviesId, tvShowEntity.moviesId)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.imgPath, tvShowEntity.imgPath)
        assertEquals(dummyTvShow.country, tvShowEntity.country)
        assertEquals(dummyTvShow.date, tvShowEntity.date)
        assertEquals(dummyTvShow.desc, tvShowEntity.desc)
        assertEquals(dummyTvShow.genre, tvShowEntity.genre)
        assertEquals(dummyTvShow.duration, tvShowEntity.duration)
        assertEquals(dummyTvShow.rate, tvShowEntity.rate)
    }
}