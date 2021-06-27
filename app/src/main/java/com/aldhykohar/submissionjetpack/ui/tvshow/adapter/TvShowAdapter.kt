package com.aldhykohar.submissionjetpack.ui.tvshow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldhykohar.submissionjetpack.data.repository.local.entity.TvShowsEntity
import com.aldhykohar.submissionjetpack.data.repository.remote.response.tvshow.TvShowsItem
import com.aldhykohar.submissionjetpack.databinding.ItemMoviesBinding
import com.aldhykohar.submissionjetpack.ui.tvshow.TvShowsListener
import com.aldhykohar.submissionjetpack.utils.CommonUtils.bindImage

/**
 * Created by aldhykohar on 5/11/2021.
 */
class TvShowAdapter(var listener: TvShowsListener) :
    RecyclerView.Adapter<TvShowAdapter.ItemViewHolder>() {
    private var listTvShows = ArrayList<TvShowsEntity>()
    fun setTvShows(tvShows: List<TvShowsEntity>?) {
        if (tvShows == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
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
        holder.bind(listTvShows[position])
    }

    override fun getItemCount(): Int = listTvShows.size

    inner class ItemViewHolder(private val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TvShowsEntity) {
            with(binding) {
                tvTitle.text = tvShows.originalName
                tvDate.text = tvShows.firstAirDate
                tvVote.text = tvShows.voteAverage.toString()

                bindImage(ivMovies, tvShows.posterPath)

                itemView.setOnClickListener {
                    listener.onItemTvShowsClicked(tvShows)
                }
            }
        }
    }
}