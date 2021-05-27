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
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsItem
import com.aldhykohar.submissionjetpack.databinding.FragmentTvshowBinding
import com.aldhykohar.submissionjetpack.ui.movie.detail.DetailMoviesActivity
import com.aldhykohar.submissionjetpack.ui.tvshow.adapter.TvShowAdapter
import com.merchantmalltronik.malltronik.malltronikkurir.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowFragment : Fragment(), TvShowsListener {

    private var from: String = TvShowFragment::class.java.name


    private val binding: FragmentTvshowBinding by lazy {
        FragmentTvshowBinding.inflate(layoutInflater)
    }

    private val tvShowsAdapter: TvShowAdapter by lazy {
        TvShowAdapter(this)
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
        observerViewModel()
    }

    private fun observerViewModel() {
        viewModel.getTvShows().observe(viewLifecycleOwner, {
            when (it.status) {
                Status.SUCCESS -> {
                    setupShimmer(false)
                    tvShowsAdapter.setTvShows(it.data?.results)
                }
                Status.LOADING -> {
                    setupShimmer(true)
                }
                Status.ERROR -> {
                    setupShimmer(false)
                }
            }
        })
    }

    private fun setupUI() {
        with(binding) {
            rvTvShow.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                adapter = tvShowsAdapter
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

    override fun onItemTvShowsClicked(tvShow: TvShowsItem) {
        val intent = Intent(context, DetailMoviesActivity::class.java)
        intent.putExtra(DetailMoviesActivity.WHERE_FROM, from)
//        intent.putExtra(DetailActivity.EXTRA_MOVIES, movies.moviesId)
        context?.startActivity(intent)
    }
}