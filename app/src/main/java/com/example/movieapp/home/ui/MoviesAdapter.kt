package com.example.movieapp.home.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.moviestorenew.home.data.Movie

class MoviesAdapter(private val context: Context,
    private val movies: List<Movie>
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private var displayedMovies = movies

    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.roundedImageView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesAdapter.MoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_card, parent, false)
        return MoviesAdapter.MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MoviesViewHolder, position: Int) {
        Glide
            .with(context)
            .load(displayedMovies[position].imageURL)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imageView);
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
