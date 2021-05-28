package com.aldhykohar.submissionjetpack.ui.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenresItem
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesItem
import com.aldhykohar.submissionjetpack.databinding.ItemMoviesBinding
import com.aldhykohar.submissionjetpack.ui.movie.MoviesListener
import com.aldhykohar.submissionjetpack.utils.CommonUtils.bindImage
import com.aldhykohar.submissionjetpack.utils.CommonUtils.getGenreMovies


/**
 * Created by aldhykohar on 5/11/2021.
 */
class MoviesAdapter(var listener: MoviesListener) :
    RecyclerView.Adapter<MoviesAdapter.ItemViewHolder>() {
    private var listMovies = ArrayList<MoviesItem>()
    private var listGenre = ArrayList<GenresItem>()

    fun setGenres(genres: List<GenresItem>?) {
        if (genres == null) return
        this.listGenre.clear()
        this.listGenre.addAll(genres)
    }

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
                val genres = getGenreMovies(listGenre, movies)
                data = movies
                genre = genres

                bindImage(ivMovies, movies.posterPath)

                itemView.setOnClickListener {
                    listener.onItemMoviesClicked(movies, genres)
                }
            }
        }
    }
}