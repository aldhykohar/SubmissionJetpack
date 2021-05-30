package com.aldhykohar.submissionjetpack.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.aldhykohar.submissionjetpack.R
import com.aldhykohar.submissionjetpack.data.api.ApiService
import com.aldhykohar.submissionjetpack.utils.EspressoIdlingResource
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

/**
 * Created by aldhykohar on 5/18/2021.
 */
@HiltAndroidTest
class HomeActivityTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Inject
    lateinit var endpoint: ApiService

    @Before
    fun setUp() {
        hiltRule.inject()
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        val data = endpoint.getMovies().execute().body()?.results
        onView(withId(R.id.rvMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                data?.size!!
            )
        )
    }

    @Test
    fun loadTvShow() {
        val data = endpoint.getTvShows().execute().body()?.results
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                data?.size!!
            )
        )
    }

    @Test
    fun loadDetailMovie() {

        val data = endpoint.getMovies().execute().body()?.results

        onView(withId(R.id.rvMovie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(data!![0].title)))
        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDate)).check(matches(withText(data[0].releaseDate)))
        onView(withId(R.id.tvDesc)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDesc)).check(matches(withText(data[0].overview)))
        onView(withId(R.id.tvRate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRate)).check(matches(withText(data[0].voteAverage.toString())))
        onView(withId(R.id.tvVoteCount)).check(matches(isDisplayed()))
        onView(withId(R.id.tvVoteCount)).check(matches(withText(data[0].voteCount.toString() + " views")))
        onView(withId(R.id.ivMovies)).check(matches(isDisplayed()))
        onView(withId(R.id.ivImgBackground)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReadMore)).perform(click())
        onView(withId(R.id.ivBack)).perform(click())
    }

    @Test
    fun loadDetailTvShow() {
        val data = endpoint.getTvShows().execute().body()?.results

        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rvTvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(data!![0].name)))
        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDate)).check(matches(withText(data[0].firstAirDate)))
        onView(withId(R.id.tvDesc)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDesc)).check(matches(withText(data[0].overview)))
        onView(withId(R.id.tvRate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRate)).check(matches(withText(data[0].voteAverage.toString())))
        onView(withId(R.id.tvVoteCount)).check(matches(isDisplayed()))
        onView(withId(R.id.tvVoteCount)).check(matches(withText(data[0].voteCount.toString() + " views")))
        onView(withId(R.id.ivMovies)).check(matches(isDisplayed()))
        onView(withId(R.id.ivImgBackground)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReadMore)).perform(click())
        onView(withId(R.id.ivBack)).perform(click())
    }

}