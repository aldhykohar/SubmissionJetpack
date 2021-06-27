package com.aldhykohar.submissionjetpack.ui.favorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.databinding.ItemMoviesBinding
import com.aldhykohar.submissionjetpack.ui.movie.MoviesListener
import com.aldhykohar.submissionjetpack.utils.CommonUtils.bindImage


/**
 * Created by aldhykohar on 5/11/2021.
 */
class FavoriteMovieAdapter(var listener: MoviesListener) :
    PagedListAdapter<MovieEntity, FavoriteMovieAdapter.ItemViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
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
        val movies = getItem(position)
        if (movies != null) {
            holder.bind(movies)
        }
    }

    inner class ItemViewHolder(private val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: MovieEntity) {
            with(binding) {
                tvTitle.text = movies.originalTitle
                tvDate.text = movies.releaseDate
                tvVote.text = movies.voteAverage.toString()

                bindImage(ivMovies, movies.posterPath)

                itemView.setOnClickListener {
                    listener.onItemMoviesClicked(movies)
                }
            }
        }
    }
}