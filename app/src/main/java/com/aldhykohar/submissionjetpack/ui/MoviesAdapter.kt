package com.aldhykohar.submissionjetpack.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldhykohar.submissionjetpack.data.model.MoviesModel
import com.aldhykohar.submissionjetpack.databinding.ItemMoviesBinding
import com.aldhykohar.submissionjetpack.ui.listener.MoviesListener
import com.squareup.picasso.Picasso


/**
 * Created by aldhykohar on 5/11/2021.
 */
class MoviesAdapter(var listener: MoviesListener) :
    RecyclerView.Adapter<MoviesAdapter.ItemViewHolder>() {
    private var listMovies = ArrayList<MoviesModel>()

    fun setMovies(courses: List<MoviesModel>?) {
        if (courses == null) return
        this.listMovies.clear()
        this.listMovies.addAll(courses)
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
        fun bind(movies: MoviesModel) {
            with(binding) {
                data = movies

                Picasso.get()
                    .load(movies.imgPath)
                    .into(ivMovies)

                itemView.setOnClickListener {
                    listener.onItemMoviesClicked(movies)
                }
            }
        }
    }
}