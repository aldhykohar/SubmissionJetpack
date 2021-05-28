package com.aldhykohar.submissionjetpack.ui.tvshow

import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsItem


/**
 * Created by aldhykohar on 5/27/2021.
 */
interface TvShowsListener {
    fun onItemTvShowsClicked(tvShow: TvShowsItem, genre: String)
}