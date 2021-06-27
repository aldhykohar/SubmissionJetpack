package com.aldhykohar.submissionjetpack.ui.favorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aldhykohar.submissionjetpack.data.repository.local.entity.TvShowsEntity
import com.aldhykohar.submissionjetpack.databinding.ItemMoviesBinding
import com.aldhykohar.submissionjetpack.ui.tvshow.TvShowsListener
import com.aldhykohar.submissionjetpack.utils.CommonUtils.bindImage


/**
 * Created by aldhykohar on 5/11/2021.
 */
class FavoriteTvShowAdapter(var listener: TvShowsListener) :
    PagedListAdapter<TvShowsEntity, FavoriteTvShowAdapter.ItemViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowsEntity>() {
            override fun areItemsTheSame(oldItem: TvShowsEntity, newItem: TvShowsEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: TvShowsEntity,
                newItem: TvShowsEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemMoviesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

    inner class ItemViewHolder(private val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowsEntity) {
            with(binding) {
                tvTitle.text = tvShow.name
                tvDate.text = tvShow.firstAirDate
                tvVote.text = tvShow.voteAverage.toString()

                bindImage(ivMovies, tvShow.posterPath)

                itemView.setOnClickListener {
                    listener.onItemTvShowsClicked(tvShow)
                }
            }
        }
    }
}