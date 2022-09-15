package com.example.movieapp.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.TopMovieCardBinding
import com.example.movieapp.home.data.MoviesModel

class TopMoviesAdapter(
    private val movies: List<MoviesModel>
) : RecyclerView.Adapter<TopMoviesAdapter.TopMoviesViewHolder>() {

    class TopMoviesViewHolder(private val binding: TopMovieCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MoviesModel) {
            Glide
                .with(itemView.context)
                .load(item.image)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.roundedImageView)
            binding.roundedImageView.setOnClickListener{
                it.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMoviesViewHolder {
        val binding = TopMovieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopMoviesViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size
}


