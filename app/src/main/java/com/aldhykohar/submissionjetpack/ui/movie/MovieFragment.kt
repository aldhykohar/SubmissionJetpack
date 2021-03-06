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
import androidx.recyclerview.widget.GridLayoutManager
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.databinding.FragmentMovieBinding
import com.aldhykohar.submissionjetpack.ui.movie.adapter.MoviesAdapter
import com.aldhykohar.submissionjetpack.ui.movie.detail.DetailMoviesActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment(), MoviesListener {

    private val binding: FragmentMovieBinding by lazy {
        FragmentMovieBinding.inflate(layoutInflater)
    }

    private val moviesAdapter: MoviesAdapter by lazy {
        MoviesAdapter(this)
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
        setupShimmer(true)
        observerViewModel()
    }

    private fun observerViewModel() {
        viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
            setupShimmer(false)
            moviesAdapter.setMovies(movies)
        })
    }

    private fun setupUI() {
        with(binding) {
            rvMovie.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(context, 2)
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

    override fun onItemMoviesClicked(movies: MovieEntity) {
        val intent = Intent(context, DetailMoviesActivity::class.java)
        intent.putExtra(DetailMoviesActivity.ID_MOVIES, movies.id)
        context?.startActivity(intent)
    }
}