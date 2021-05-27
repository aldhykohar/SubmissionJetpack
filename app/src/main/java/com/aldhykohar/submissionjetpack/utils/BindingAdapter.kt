package com.aldhykohar.submissionjetpack.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.aldhykohar.submissionjetpack.BuildConfig
import com.squareup.picasso.Picasso


/**
 * Created by aldhykohar on 5/27/2021.
 */

//@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, img_path: String?) {
    img_path?.let {
        Picasso.get()
            .load("${BuildConfig.IMAGE_URL}$img_path")
            .into(imageView)
    }
}