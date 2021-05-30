package com.aldhykohar.submissionjetpack.utils

import androidx.test.espresso.idling.CountingIdlingResource


/**
 * Created by aldhykohar on 5/30/2021.
 */
object EspressoIdlingResource {
    private const val RESOURCE = "GLOBAL"
    val idlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        idlingResource.increment()
    }

    fun decrement() {
        idlingResource.decrement()
    }
}