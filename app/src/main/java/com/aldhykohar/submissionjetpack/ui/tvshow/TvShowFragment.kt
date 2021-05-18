package com.aldhykohar.submissionjetpack.ui.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aldhykohar.submissionjetpack.data.model.MoviesModel
import com.aldhykohar.submissionjetpack.databinding.FragmentTvshowBinding
import com.aldhykohar.submissionjetpack.ui.MoviesAdapter
import com.aldhykohar.submissionjetpack.ui.detail.DetailActivity
import com.aldhykohar.submissionjetpack.ui.listener.MoviesListener

class TvShowFragment : Fragment(), MoviesListener {

    private var from: String = TvShowFragment::class.java.name


    private val binding: FragmentTvshowBinding by lazy {
        FragmentTvshowBinding.inflate(layoutInflater)
    }

    private val viewModel: TvShowViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        val moviesAdapter = MoviesAdapter(this)
        setupShimmer(true)
        moviesAdapter.setMovies(viewModel.getTvShow())
        setupShimmer(false)
        with(binding) {
            rvTvShow.apply {
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
                rvTvShow.visibility = View.GONE
            } else {
                shimmer.visibility = View.GONE
                shimmer.stopShimmer()
                rvTvShow.visibility = View.VISIBLE
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