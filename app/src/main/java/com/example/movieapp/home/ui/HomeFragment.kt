package com.example.movieapp.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.moviestorenew.home.data.DataSource
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTopMovies.adapter = TopMoviesAdapter(DataSource.getTopMovies())
        binding.rvActionMovies.adapter=MoviesAdapter(DataSource.getMovies())
        binding.tvActionViewAll.setOnClickListener{toExpandedList()}
    }

    private fun toExpandedList()
    {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToExpandedListFragment("Action Movies",DataSource.getMovies().toTypedArray()))
    }

}