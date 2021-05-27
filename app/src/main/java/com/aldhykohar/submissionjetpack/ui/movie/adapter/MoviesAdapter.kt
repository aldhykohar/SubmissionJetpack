package com.aldhykohar.submissionjetpack.ui.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldhykohar.submissionjetpack.data.model.MoviesModel
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesItem
import com.aldhykohar.submissionjetpack.databinding.ItemMoviesBinding
import com.aldhykohar.submissionjetpack.ui.movie.MoviesListener
import com.aldhykohar.submissionjetpack.utils.bindImage
import com.squareup.picasso.Picasso


/**
 * Created by aldhykohar on 5/11/2021.
 */
class MoviesAdapter(var listener: MoviesListener) :
    RecyclerView.Adapter<MoviesAdapter.ItemViewHolder>() {
    private var listMovies = ArrayList<MoviesItem>()

    fun setMovies(movies: List<MoviesItem>?) {
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
        fun bind(movies: MoviesItem) {
            with(binding) {
                data = movies

                bindImage(ivMovies,movies.posterPath)

                itemView.setOnClickListener {
                    listener.onItemMoviesClicked(movies)
                }
            }
        }
    }
}