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

class TopMoviesAdapter(private val context: Context,
    private val movies: List<Movie>
) : RecyclerView.Adapter<TopMoviesAdapter.TopMoviesViewHolder>() {
    class TopMoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.roundedImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.top_movie_card, parent, false)
        return TopMoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopMoviesViewHolder, position: Int) {
        Glide
            .with(context)
            .load(movies[position].imageURL)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imageView)
    }

    override fun getItemCount() = movies.size
}


