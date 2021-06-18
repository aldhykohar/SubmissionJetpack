package com.aldhykohar.submissionjetpack.ui.tvshow.detail

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aldhykohar.submissionjetpack.R
import com.aldhykohar.submissionjetpack.databinding.ActivityDetailTvShowBinding
import com.aldhykohar.submissionjetpack.utils.CommonUtils
import com.aldhykohar.submissionjetpack.utils.CommonUtils.bindImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val ID_TV_SHOW = "id_tv_show"
    }

    private val binding: ActivityDetailTvShowBinding by lazy {
        ActivityDetailTvShowBinding.inflate(layoutInflater)
    }

    private val viewModel: DetailTvShowViewModel by viewModels()

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
        val tvShowId = intent.getIntExtra(ID_TV_SHOW, 0)
        doLoadDetailTvShow(tvShowId)
    }

    private fun doLoadDetailTvShow(tvShowId: Int) {
        viewModel.getDetailTvShow(tvShowId).observe(this, { data ->
            setupShimmer(false)
            with(binding) {
                model = data
                genre = CommonUtils.getGenres(data.genres)
                bindImage(ivMovies, data.posterPath)
                bindImage(ivImgBackground, data.backdropPath)
            }
        })
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