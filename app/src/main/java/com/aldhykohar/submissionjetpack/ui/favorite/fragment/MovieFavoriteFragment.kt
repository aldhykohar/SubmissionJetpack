package com.aldhykohar.submissionjetpack.ui.favorite.fragment

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
import com.aldhykohar.submissionjetpack.databinding.FragmentMovieFavBinding
import com.aldhykohar.submissionjetpack.ui.favorite.FavoriteViewModel
import com.aldhykohar.submissionjetpack.ui.favorite.adapter.FavoriteMovieAdapter
import com.aldhykohar.submissionjetpack.ui.movie.MoviesListener
import com.aldhykohar.submissionjetpack.ui.movie.detail.DetailMoviesActivity
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by aldhykohar on 6/26/2021.
 */

@AndroidEntryPoint
class MovieFavoriteFragment : Fragment(), MoviesListener {
    private val binding: FragmentMovieFavBinding by lazy {
        FragmentMovieFavBinding.inflate(layoutInflater)
    }

    private val moviesAdapter: FavoriteMovieAdapter by lazy {
        FavoriteMovieAdapter(this)
    }

    private val viewModel: FavoriteViewModel by viewModels()

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
        viewModel.getFavoriteMovie().observe(viewLifecycleOwner, { movies ->
            setupShimmer(false)
            if (movies.size == 0) binding.empty.root.visibility = VISIBLE
            moviesAdapter.submitList(movies)
        })
    }

    private fun setupUI() {
        with(binding) {
            rvMovieFav.apply {
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
                rvMovieFav.visibility = GONE
            } else {
                shimmer.visibility = GONE
                shimmer.stopShimmer()
                rvMovieFav.visibility = VISIBLE
            }
        }
    }

    override fun onItemMoviesClicked(movies: MovieEntity) {
        val intent = Intent(context, DetailMoviesActivity::class.java)
        intent.putExtra(DetailMoviesActivity.ID_MOVIES, movies.id)
        context?.startActivity(intent)
    }
}