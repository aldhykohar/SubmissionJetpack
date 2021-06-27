package com.aldhykohar.submissionjetpack.ui.favorite.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.aldhykohar.submissionjetpack.data.repository.local.entity.TvShowsEntity
import com.aldhykohar.submissionjetpack.databinding.FragmentTvShowFavBinding
import com.aldhykohar.submissionjetpack.ui.favorite.FavoriteViewModel
import com.aldhykohar.submissionjetpack.ui.favorite.adapter.FavoriteTvShowAdapter
import com.aldhykohar.submissionjetpack.ui.tvshow.TvShowsListener
import com.aldhykohar.submissionjetpack.ui.tvshow.detail.DetailTvShowActivity
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by aldhykohar on 6/26/2021.
 */

@AndroidEntryPoint
class TvShowFavoriteFragment : Fragment(), TvShowsListener {
    private val binding: FragmentTvShowFavBinding by lazy {
        FragmentTvShowFavBinding.inflate(layoutInflater)
    }

    private val moviesAdapter: FavoriteTvShowAdapter by lazy {
        FavoriteTvShowAdapter(this)
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
        viewModel.getFavoriteTvSHow().observe(viewLifecycleOwner, { tvShow ->
            if (tvShow.size == 0) binding.empty.root.visibility = VISIBLE
            setupShimmer(false)
            moviesAdapter.submitList(tvShow)
        })
    }

    private fun setupUI() {
        with(binding) {
            rvTvShowFav.apply {
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
                rvTvShowFav.visibility = View.GONE
            } else {
                shimmer.visibility = View.GONE
                shimmer.stopShimmer()
                rvTvShowFav.visibility = VISIBLE
            }
        }
    }

    override fun onItemTvShowsClicked(tvShow: TvShowsEntity) {
        val intent = Intent(context, DetailTvShowActivity::class.java)
        intent.putExtra(DetailTvShowActivity.ID_TV_SHOW, tvShow.id)
        context?.startActivity(intent)
    }
}