package com.example.movieapp.search.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.MovieSearchCardBinding
import com.example.movieapp.home.data.MovieModel

class MoviesSearchAdapter(
    private val movies: List<MovieModel>,
) : RecyclerView.Adapter<MoviesSearchAdapter.MoviesSearchViewHolder>() {

    private var filter: List<MovieModel> = listOf()

    class MoviesSearchViewHolder(private val binding: MovieSearchCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieModel) {
            Glide
                .with(itemView.context)
                .load(item.imageURL)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.roundedImageView)
            binding.tvMovieName.text = item.title
            binding.tvMovieTime.text = item.duration.toString()
            binding.tvMovieCategory.text = "Action"
            binding.tvDirectorName.text="Otto Bathurst"
            binding.tvMovieYear.text="2018"
            binding.ratingBar.rating= 3.5F
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesSearchViewHolder {
        val binding = MovieSearchCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesSearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesSearchViewHolder, position: Int) {
        holder.bind(filter[position])
    }

    override fun getItemCount() = filter.size

    fun changeList(query: String?) {
        filter = movies.filter {
            it.title.contains(query as CharSequence)
        }
        notifyDataSetChanged()
    }
    fun setEmpty() {
        filter = emptyList()
        notifyDataSetChanged()
    }

}
