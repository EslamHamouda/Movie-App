package com.example.movieapp.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.MovieCardBinding
import com.example.movieapp.home.data.MovieModel
import com.example.movieapp.home.data.MoviesModel

class MoviesAdapter(
    private val movies: List<MoviesModel>,private val flag: Boolean
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private var displayedMovies = movies

    class MoviesViewHolder(private val binding: MovieCardBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MoviesModel, flag: Boolean) {
            Glide
                .with(itemView.context)
                .load(item.image)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.roundedImageView)
            binding.tvMovieName.text = item.movieName
            binding.tvMovieTime.text = "${item.time?.div(60)}h ${item.time?.mod(60)}m"
            if (!flag) {
                binding.item.setOnClickListener {
                    it.findNavController()
                        .navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item))
                }
            } else {
                binding.item.setOnClickListener {
                    it.findNavController().navigate(
                        ExpandedMoviesFragmentDirections.actionExpandedMoviesFragmentToDetailsFragment(
                            item
                        )
                    )
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = MovieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movies[position],flag)
    }

    override fun getItemCount(): Int {
        val size=if(flag) displayedMovies.size else displayedMovies.take(3).size
        return size
    }

}
