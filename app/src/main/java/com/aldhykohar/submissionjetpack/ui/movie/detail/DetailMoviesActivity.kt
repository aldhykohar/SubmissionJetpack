package com.aldhykohar.submissionjetpack.ui.movie.detail

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aldhykohar.submissionjetpack.R
import com.aldhykohar.submissionjetpack.data.model.MoviesModel
import com.aldhykohar.submissionjetpack.databinding.ActivityDetailMoviesBinding
import com.aldhykohar.submissionjetpack.ui.movie.MovieFragment
import com.squareup.picasso.Picasso

class DetailMoviesActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIES = "extra_movies"
        const val WHERE_FROM = "where_from"
    }

    private val binding: ActivityDetailMoviesBinding by lazy {
        ActivityDetailMoviesBinding.inflate(layoutInflater)
    }

    private val viewModel: DetailMoviesViewModel by viewModels()

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
        val extras = intent.extras
        if (extras != null) {
            val moviesId = extras.getString(EXTRA_MOVIES)
            val whereFrom = extras.getString(WHERE_FROM)
            if (moviesId != null) {
                viewModel.setSelectedMovies(moviesId)
                if (whereFrom.equals(MovieFragment::class.java.name)) {
                    populateMovies(viewModel.getMovies())
                } else {
                    populateMovies(viewModel.getTvShow())
                }
            }
        }
    }

    private fun populateMovies(movies: MoviesModel) {
        setupShimmer(false)
        binding.model = movies
        with(binding) {
            Picasso.get()
                .load(movies.imgPath)
                .into(ivMovies)

            Picasso.get()
                .load(movies.imgPath)
                .into(ivImgBackground)
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