package com.example.movieapp.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.moviestorenew.home.data.DataSource
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val topMoviesRecyclerView: RecyclerView = view.findViewById(R.id.topMovies_recyclerView)

        val moviesRecyclerView: RecyclerView = view.findViewById(R.id.moviesGrid_recyclerView)
        moviesRecyclerView.adapter = MoviesAdapter(requireContext(),DataSource.getMovies()
        )

        val tabLayout: TabLayout = view.findViewById(R.id.tabLayout)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.text) {
                    getString(R.string.now_playing) -> {
                        (moviesRecyclerView.adapter as MoviesAdapter).resetMovies()
                    }
                    getString(R.string.upcoming) -> {
                        (moviesRecyclerView.adapter as MoviesAdapter).filterMovies("Jurassic World Dominion")
                    }
                    getString(R.string.top_rated) -> {
                        (moviesRecyclerView.adapter as MoviesAdapter).filterMovies("The Shawshank Redemption")
                    }
                    getString(R.string.popular) -> {
                        (moviesRecyclerView.adapter as MoviesAdapter).filterMovies("Spider-Man: No Way Home")
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        topMoviesRecyclerView.adapter = TopMoviesAdapter(requireContext(),DataSource.getTopMovies())
    }

}