package com.aldhykohar.submissionjetpack.ui.tvshow.detail

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.aldhykohar.submissionjetpack.R
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsItem
import com.aldhykohar.submissionjetpack.databinding.ActivityDetailTvShowBinding
import com.aldhykohar.submissionjetpack.utils.CommonUtils.bindImage

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
        const val GENRE = "genre"
    }

    private val binding: ActivityDetailTvShowBinding by lazy {
        ActivityDetailTvShowBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupData()
        setupListener()
    }

    private fun setupListener() {
        with(binding) {
            ivBack.setOnClickListener { onBackPressed() }
            tvReadMore.setOnClickListener { setupReadMore() }
        }
    }

    private fun setupReadMore() {
        with(binding) {
            if (tvReadMore.text.toString() == getString(R.string.selengkapnya)) {
                tvDesc.apply {
                    maxLines = Integer.MAX_VALUE
                    ellipsize = null
                }
                tvReadMore.text = getString(R.string.sembunyikan)
            } else {
                tvDesc.apply {
                    maxLines = 4
                    ellipsize = TextUtils.TruncateAt.END
                }
                tvReadMore.text = getString(R.string.selengkapnya)
            }
        }
    }

    private fun setupData() {
        setupShimmer(true)

        val genres = intent.getStringExtra(GENRE)
        val data: TvShowsItem? = intent.getParcelableExtra(EXTRA_TV_SHOW)
        if (data != null) {
            setupShimmer(false)
            with(binding) {
                model = data
                genre = genres
                bindImage(ivMovies, data.posterPath)
                bindImage(ivImgBackground, data.backdropPath)

            }

        }
    }

    private fun setupShimmer(state: Boolean) {
        with(binding) {
            if (state) {
                shimmer.visibility = View.VISIBLE
                shimmer.startShimmer()
                container.visibility = View.GONE
            } else {
                shimmer.visibility = View.GONE
                shimmer.stopShimmer()
                container.visibility = View.VISIBLE
            }
        }
    }
}