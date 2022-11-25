package com.example.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.ActorCardBinding
import com.example.movieapp.data.models.response.ActorModel

class ActorsAdapter(
    private val actors: List<ActorModel>, private val flag:Boolean
) : RecyclerView.Adapter<ActorsAdapter.MoviesViewHolder>() {
    private var displayedMovies = actors

    class MoviesViewHolder(private val binding: ActorCardBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ActorModel) {
            Glide
                .with(itemView.context)
                .load(item.actorImagePath)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.roundedImageView)
            binding.tvActorName.text=item.actorName

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ActorCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(actors[position])
    }

    override fun getItemCount():Int {
        val size=if(flag) displayedMovies.size else displayedMovies.take(3).size
        return size
    }
}
