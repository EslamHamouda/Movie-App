package com.example.movieapp.search.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.MovieSearchCardBinding
import com.example.movieapp.home.data.MovieModel
import com.example.movieapp.home.data.MoviesModel

class MoviesSearchAdapter(
    private var movies: List<MoviesModel>,
) : RecyclerView.Adapter<MoviesSearchAdapter.MoviesSearchViewHolder>() {

    class MoviesSearchViewHolder(private val binding: MovieSearchCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MoviesModel) {
            Glide
                .with(itemView.context)
                .load(item.image)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.roundedImageView)
            binding.tvMovieName.text = item.movieName
            binding.tvMovieTime.text = "${item.time?.div(60)}h ${item.time?.mod(60)}m"
            binding.tvMovieCategory.text = item.category
            binding.tvDirectorName.text=item.directorName
            binding.tvMovieYear.text= item.releasedYear.toString()
            binding.ratingBar.rating= (1..5).random().toFloat()
            binding.item.setOnClickListener{
                it.findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToDetailsFragment(item))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesSearchViewHolder {
        val binding = MovieSearchCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesSearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesSearchViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

    fun setEmpty() {
        movies = emptyList()
        notifyDataSetChanged()
    }

}
