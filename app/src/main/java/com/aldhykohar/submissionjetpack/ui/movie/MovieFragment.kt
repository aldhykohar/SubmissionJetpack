package com.aldhykohar.submissionjetpack.ui.movie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesItem
import com.aldhykohar.submissionjetpack.databinding.FragmentMovieBinding
import com.aldhykohar.submissionjetpack.ui.movie.adapter.MoviesAdapter
import com.aldhykohar.submissionjetpack.ui.movie.detail.DetailMoviesActivity
import com.merchantmalltronik.malltronik.malltronikkurir.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment(), MoviesListener {

    var from: String = MovieFragment::class.java.name

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
        observerViewModel()
    }

    private fun observerViewModel() {
        viewModel.getMovies().observe(viewLifecycleOwner, {
            when (it.status) {
                Status.SUCCESS -> {
                    setupShimmer(false)
                    moviesAdapter.setMovies(it.data?.results)
//                    Log.e("Movie", "${it.data}")
                }
                Status.LOADING -> {
                    setupShimmer(true)
                }
                Status.ERROR -> {
                    setupShimmer(false)

                    Log.e("Movie", "${it.message}")
                }
            }
        })
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

    override fun onItemMoviesClicked(movies: MoviesItem) {
        val intent = Intent(context, DetailMoviesActivity::class.java)
        intent.putExtra(DetailMoviesActivity.WHERE_FROM, from)
//        intent.putExtra(DetailActivity.EXTRA_MOVIES, movies.moviesId)
        context?.startActivity(intent)
    }
}