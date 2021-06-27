package com.aldhykohar.submissionjetpack.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.aldhykohar.submissionjetpack.BuildConfig
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenresItem
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.MoviesItem
import com.aldhykohar.submissionjetpack.data.repository.remote.response.tvshow.TvShowsItem
import com.squareup.picasso.Picasso


/**
 * Created by aldhykohar on 5/28/2021.
 */
object CommonUtils {
    fun bindImage(imageView: ImageView, img_path: String?) {
        img_path?.let {
            Picasso.get()
                .load("${BuildConfig.IMAGE_URL}$img_path")
                .into(imageView)
        }
    }

    fun Context.showToast(message: String, type: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, type).show()
    }

    fun getGenres(listGenre: List<GenresItem>): String {
        val list: ArrayList<String> = ArrayList()
        for (gn in listGenre) {
            list.add(gn.name)
        }
        return list.joinToString(separator = ", ")
    }
}