package com.example.movieapp.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.movieapp.databinding.FragmentExpandedListBinding

class ExpandedListFragment : Fragment() {
    lateinit var binding: FragmentExpandedListBinding
    val args:ExpandedListFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentExpandedListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvCategoryName.text=args.category
        binding.rvExpandedMovieList.adapter=ExpandedMoviesAdapter(args.list.asList())
        binding.arrowBack.setOnClickListener{goHome()}
    }

    private fun goHome(){
        findNavController().navigate(ExpandedListFragmentDirections.actionExpandedListFragmentToHomeFragment())
    }

}