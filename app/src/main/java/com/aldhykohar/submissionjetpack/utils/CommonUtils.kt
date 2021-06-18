package com.aldhykohar.submissionjetpack.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.aldhykohar.submissionjetpack.BuildConfig
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

    fun getGenreMovies(listGenre: List<GenresItem>, movies: MoviesItem): String {
        val list: ArrayList<String> = ArrayList()
        out_loop@ for ((i, genre) in movies.genreIds.withIndex()) {
            for (gn in listGenre) {
                if (gn.id == genre) {
                    if (i == 3) break@out_loop
                    list.add(gn.name)
                }
            }
        }
        return list.joinToString(separator = ", ")
    }

    fun getGenres(listGenre: List<GenresItem>): String {
        val list: ArrayList<String> = ArrayList()
        for (gn in listGenre) {
            list.add(gn.name)
        }
        return list.joinToString(separator = ", ")
    }

    fun getGenreTvShow(listGenre: List<GenresItem>, tvShow: TvShowsItem): String {
        val list: ArrayList<String> = ArrayList()
        out_loop@ for ((i, genre) in tvShow.genreIds.withIndex()) {
            for (gn in listGenre) {
                if (gn.id == genre) {
                    if (i == 3) break@out_loop
                    list.add(gn.name)
                }
            }
        }
        return list.joinToString(separator = ", ")
    }
}