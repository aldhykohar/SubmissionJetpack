package com.aldhykohar.submissionjetpack.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aldhykohar.submissionjetpack.data.model.MoviesModel
import com.aldhykohar.submissionjetpack.databinding.FragmentMovieBinding
import com.aldhykohar.submissionjetpack.ui.MoviesAdapter
import com.aldhykohar.submissionjetpack.ui.detail.DetailActivity
import com.aldhykohar.submissionjetpack.ui.listener.MoviesListener

class MovieFragment : Fragment(), MoviesListener {

    var from: String = MovieFragment::class.java.name

    private val binding: FragmentMovieBinding by lazy {
        FragmentMovieBinding.inflate(layoutInflater)
    }

    private val viewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            setupUI()
        }
    }

    private fun setupUI() {
        val moviesAdapter = MoviesAdapter(this)
        setupShimmer(true)
        moviesAdapter.setMovies(viewModel.getMovie())
        setupShimmer(false)
        with(binding) {
            rvMovie.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                adapter = moviesAdapter
            }
        }
    }

    private fun setupShimmer(state: Boolean) {
        with(binding) {
            if (state) {
                shimmer.visibility = VISIBLE
                shimmer.startShimmer()
                rvMovie.visibility = GONE
            } else {
                shimmer.visibility = GONE
                shimmer.stopShimmer()
                rvMovie.visibility = VISIBLE
            }
        }
    }

    override fun onItemMoviesClicked(movies: MoviesModel) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.WHERE_FROM, from)
        intent.putExtra(DetailActivity.EXTRA_MOVIES, movies.moviesId)
        context?.startActivity(intent)
    }
}