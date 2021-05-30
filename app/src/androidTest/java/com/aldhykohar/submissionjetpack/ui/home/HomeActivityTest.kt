package com.aldhykohar.submissionjetpack.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.aldhykohar.submissionjetpack.R
import com.aldhykohar.submissionjetpack.utils.DataDummy
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

/**
 * Created by aldhykohar on 5/18/2021.
 */
@HiltAndroidTest
class HomeActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rvMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadTvShow() {
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.tvDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDate)).check(matches(withText(dummyMovie[0].date)))
        onView(withId(R.id.tvDesc)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDesc)).check(matches(withText(dummyMovie[0].desc)))
        onView(withId(R.id.tvRate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRate)).check(matches(withText(dummyMovie[0].rate)))
        onView(withId(R.id.ivMovies)).check(matches(isDisplayed()))
        onView(withId(R.id.ivImgBackground)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReadMore)).perform(click())
        onView(withId(R.id.ivBack)).perform(click())
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenre)).check(matches(withText(dummyTvShow[0].genre)))
        onView(withId(R.id.tvDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDate)).check(matches(withText(dummyTvShow[0].date)))
        onView(withId(R.id.tvDesc)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDesc)).check(matches(withText(dummyTvShow[0].desc)))
        onView(withId(R.id.tvRate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRate)).check(matches(withText(dummyTvShow[0].rate)))
        onView(withId(R.id.ivMovies)).check(matches(isDisplayed()))
        onView(withId(R.id.ivImgBackground)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReadMore)).perform(click())
        onView(withId(R.id.ivBack)).perform(click())
    }

}