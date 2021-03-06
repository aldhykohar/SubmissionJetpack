package com.aldhykohar.submissionjetpack.ui.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.databinding.ItemMoviesBinding
import com.aldhykohar.submissionjetpack.ui.movie.MoviesListener
import com.aldhykohar.submissionjetpack.utils.CommonUtils.bindImage


/**
 * Created by aldhykohar on 5/11/2021.
 */
class MoviesAdapter(var listener: MoviesListener) :
    RecyclerView.Adapter<MoviesAdapter.ItemViewHolder>() {
    private var listMovies = ArrayList<MovieEntity>()

    fun setMovies(movies: List<MovieEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
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
        holder.bind(listMovies[position])
    }

    override fun getItemCount(): Int = listMovies.size

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