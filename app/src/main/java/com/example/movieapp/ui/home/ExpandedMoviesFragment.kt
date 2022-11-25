package com.example.movieapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.movieapp.databinding.FragmentExpandedMoviesBinding
import com.example.movieapp.ui.adapter.MoviesAdapter

class ExpandedMoviesFragment : Fragment() {
    lateinit var binding: FragmentExpandedMoviesBinding
    val args: ExpandedMoviesFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= FragmentExpandedMoviesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvCategoryName.text=args.category
        binding.rvExpandedMovieList.adapter= MoviesAdapter(args.list.toList(),true)
        binding.arrowBack.setOnClickListener{goHome()}
    }

    private fun goHome(){
        findNavController().navigate(ExpandedMoviesFragmentDirections.actionExpandedMoviesFragmentToHomeFragment())
    }

}