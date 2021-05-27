package com.aldhykohar.submissionjetpack.ui.tvshow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsItem
import com.aldhykohar.submissionjetpack.databinding.ItemTvShowsBinding
import com.aldhykohar.submissionjetpack.ui.movie.MoviesListener
import com.aldhykohar.submissionjetpack.ui.tvshow.TvShowsListener
import com.aldhykohar.submissionjetpack.utils.bindImage


/**
 * Created by aldhykohar on 5/11/2021.
 */
class TvShowAdapter(var listener: TvShowsListener) :
    RecyclerView.Adapter<TvShowAdapter.ItemViewHolder>() {
    private var listTvShows = ArrayList<TvShowsItem>()

    fun setTvShows(tvShows: List<TvShowsItem>?) {
        if (tvShows == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemTvShowsBinding.inflate(
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

    inner class ItemViewHolder(private val binding: ItemTvShowsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TvShowsItem) {
            with(binding) {
                data = tvShows

                bindImage(ivMovies, tvShows.posterPath)

                itemView.setOnClickListener {
                    listener.onItemTvShowsClicked(tvShows)
                }
            }
        }
    }
}