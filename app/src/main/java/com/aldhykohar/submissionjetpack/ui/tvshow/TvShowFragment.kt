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
import com.aldhykohar.submissionjetpack.ui.tvshow.adapter.TvShowAdapter
import com.aldhykohar.submissionjetpack.ui.tvshow.detail.DetailTvShowActivity
import com.aldhykohar.submissionjetpack.utils.CommonUtils.showToast
import com.aldhykohar.submissionjetpack.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowFragment : Fragment(), TvShowsListener {

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
        setupShimmer(true)
        observerViewModel()
    }

    private fun observerViewModel() {
        /*viewModel.getGenreTvShow().observe(viewLifecycleOwner, {
            when (it.status) {
                Status.SUCCESS -> {
                    tvShowsAdapter.setGenres(it.data?.genres)
                }
                Status.LOADING -> {
                }
                Status.ERROR -> {
                    context?.showToast(it.message.toString())
                }
            }
        })
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
                    context?.showToast(it.message.toString())
                }
            }
        })*/

        viewModel.getTvShows().observe(viewLifecycleOwner, { movies ->
            setupShimmer(false)
            tvShowsAdapter.setTvShows(movies)
        })

        viewModel.getTvShowGenre().observe(viewLifecycleOwner, { genres ->
            tvShowsAdapter.setGenres(genres)
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

    override fun onItemTvShowsClicked(tvShow: TvShowsItem, genre: String) {
        val intent = Intent(context, DetailTvShowActivity::class.java)
        intent.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, tvShow)
        intent.putExtra(DetailTvShowActivity.GENRE, genre)
        context?.startActivity(intent)
    }
}