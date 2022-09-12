package com.example.movieapp.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.ExpandedMovieCardBinding
import com.example.movieapp.databinding.MovieCardBinding
import com.example.movieapp.home.data.MovieModel

class ExpandedMoviesAdapter(
    private val movies: List<MovieModel>
) : RecyclerView.Adapter<ExpandedMoviesAdapter.MoviesViewHolder>() {
    private var displayedMovies = movies

    class MoviesViewHolder(private val binding: ExpandedMovieCardBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MovieModel) {
            Glide
                .with(itemView.context)
                .load(item.imageURL)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.roundedImageView)
            binding.tvMovieName.text=item.title
            binding.tvMovieTime.text="1h 12m"

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ExpandedMovieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = displayedMovies.size

    fun filterMovies(title: String) {
        displayedMovies = movies.filter {
            it.title == title
        }
        notifyDataSetChanged()
    }

    fun resetMovies() {
        displayedMovies = movies
        notifyDataSetChanged()
    }

}
