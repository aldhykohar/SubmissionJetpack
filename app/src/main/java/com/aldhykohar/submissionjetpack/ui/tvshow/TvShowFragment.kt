package com.aldhykohar.submissionjetpack.ui.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.aldhykohar.submissionjetpack.data.repository.local.entity.TvShowsEntity
import com.aldhykohar.submissionjetpack.databinding.FragmentTvshowBinding
import com.aldhykohar.submissionjetpack.ui.tvshow.adapter.TvShowAdapter
import com.aldhykohar.submissionjetpack.ui.tvshow.detail.DetailTvShowActivity
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

        viewModel.getTvShows().observe(viewLifecycleOwner, { movies ->
            setupShimmer(false)
            tvShowsAdapter.setTvShows(movies)
        })
    }

    private fun setupUI() {
        with(binding) {
            rvTvShow.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(context, 2)
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

    override fun onItemTvShowsClicked(tvShow: TvShowsEntity) {
        val intent = Intent(context, DetailTvShowActivity::class.java)
        intent.putExtra(DetailTvShowActivity.ID_TV_SHOW, tvShow.id)
        context?.startActivity(intent)
    }
}