package com.aldhykohar.submissionjetpack.ui.favorite.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.databinding.FragmentMovieBinding
import com.aldhykohar.submissionjetpack.ui.favorite.FavoriteViewModel
import com.aldhykohar.submissionjetpack.ui.movie.MovieViewModel
import com.aldhykohar.submissionjetpack.ui.movie.MoviesListener
import com.aldhykohar.submissionjetpack.ui.movie.adapter.MoviesAdapter
import com.aldhykohar.submissionjetpack.ui.movie.detail.DetailMoviesActivity
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by aldhykohar on 6/26/2021.
 */

@AndroidEntryPoint
class MovieFavoriteFragment : Fragment(), MoviesListener {
    private val binding: FragmentMovieBinding by lazy {
        FragmentMovieBinding.inflate(layoutInflater)
    }

    private val moviesAdapter: MoviesAdapter by lazy {
        MoviesAdapter(this)
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
        viewModel.getFavorite().observe(viewLifecycleOwner, { movies ->
            setupShimmer(false)
            moviesAdapter.setMovies(movies)
        })

        /*viewModel.getMoviesGenre().observe(viewLifecycleOwner, { genres ->
            moviesAdapter.setGenres(genres)
        })*/
    }

    private fun setupUI() {
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
                shimmer.visibility = View.VISIBLE
                shimmer.startShimmer()
                rvMovie.visibility = View.GONE
            } else {
                shimmer.visibility = View.GONE
                shimmer.stopShimmer()
                rvMovie.visibility = View.VISIBLE
            }
        }
    }

    override fun onItemMoviesClicked(movies: MovieEntity, genre: String) {
        val intent = Intent(context, DetailMoviesActivity::class.java)
        intent.putExtra(DetailMoviesActivity.ID_MOVIES, movies.id)
        context?.startActivity(intent)
    }
}