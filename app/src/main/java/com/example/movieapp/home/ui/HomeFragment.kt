package com.example.movieapp.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.home.data.ActorModel
import com.example.movieapp.home.view_model.HomeViewModel
import com.example.moviestorenew.home.data.DataSource
import kotlinx.coroutines.launch
import retrofit2.Response


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    val viewModel:HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getActors()
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
        binding.rvActionMovies.adapter=MoviesAdapter(DataSource.getMovies(),false)

        lifecycleScope.launch {
            viewModel.getActorsLiveData.observe(viewLifecycleOwner) {list->
                binding.rvActorsMovies.adapter= list.body()?.let { it1 -> ActorsAdapter(it1,false) }
                binding.tvActorsViewAll.setOnClickListener{toExpandedActors(list)}
            }

        }
        //binding.rvActorsMovies.adapter=ActorsAdapter(DataSource.getMovies(),false)
        binding.tvActionViewAll.setOnClickListener{toExpandedMovies()}
        //binding.tvActorsViewAll.setOnClickListener{toExpandedActors()}
    }

    private fun toExpandedMovies()
    {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToExpandedMoviesFragment("Action Movies",DataSource.getMovies().toTypedArray()))
    }
    private fun toExpandedActors(list:Response<List<ActorModel>>)
    {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToExpandedActorsFragment(list.body()!!.toTypedArray()))
    }

}