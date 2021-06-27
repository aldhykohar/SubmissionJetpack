package com.aldhykohar.submissionjetpack.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
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

        val movieId = endpoint.getMovies().execute().body()?.results!![0].id
        val data = endpoint.getDetailMovie(movieId).execute().body()

        onView(withId(R.id.rvMovie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(data!!.title)))
        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDate)).check(matches(withText(data.releaseDate)))
        onView(withId(R.id.tvDesc)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDesc)).check(matches(withText(data.overview)))
        onView(withId(R.id.tvRate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRate)).check(matches(withText(data.voteAverage.toString())))
        onView(withId(R.id.tvVoteCount)).check(matches(isDisplayed()))
        onView(withId(R.id.tvVoteCount)).check(matches(withText(data.voteCount.toString() + " views")))
        onView(withId(R.id.ivMovies)).check(matches(isDisplayed()))
        onView(withId(R.id.ivImgBackground)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReadMore)).perform(click())
        onView(withId(R.id.ivBack)).perform(click())
    }

    @Test
    fun loadDetailTvShow() {
        val tvShowId = endpoint.getTvShows().execute().body()?.results!![0].id
        val data = endpoint.getDetailTvShow(tvShowId).execute().body()

        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rvTvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(data!!.name)))
        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDate)).check(matches(withText(data.firstAirDate)))
        onView(withId(R.id.tvDesc)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDesc)).check(matches(withText(data.overview)))
        onView(withId(R.id.tvRate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRate)).check(matches(withText(data.voteAverage.toString())))
        onView(withId(R.id.tvVoteCount)).check(matches(isDisplayed()))
        onView(withId(R.id.tvVoteCount)).check(matches(withText(data.voteCount.toString() + " views")))
        onView(withId(R.id.ivMovies)).check(matches(isDisplayed()))
        onView(withId(R.id.ivImgBackground)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReadMore)).perform(click())
        onView(withId(R.id.ivBack)).perform(click())
    }

    @Test
    fun loadFavoriteMovies() {
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.fbFav)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.action_fav)).perform(click())
        onView(withId(R.id.rvMovieFav)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovieFav)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.fbFav)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun loadFavoriteTvShow() {
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.fbFav)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.action_fav)).perform(click())
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rvTvShowFav)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShowFav)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.fbFav)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }

}