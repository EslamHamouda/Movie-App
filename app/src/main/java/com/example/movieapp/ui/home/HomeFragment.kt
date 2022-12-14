package com.example.movieapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.data.models.response.ActorModel
import com.example.movieapp.data.models.response.MoviesModel
import com.example.movieapp.ui.adapter.ActorsAdapter
import com.example.movieapp.ui.adapter.MoviesAdapter
import com.example.movieapp.ui.adapter.TopMoviesAdapter
import com.example.movieapp.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import retrofit2.Response

@AndroidEntryPoint
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater)
        viewModel.getTopMovies()
        viewModel.getActors()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvName.text= getString(R.string.welcome_home_ahmed).plus(
            requireActivity().getSharedPreferences("uId",0).getString("name",""))
        lifecycleScope.launch {
            viewModel.getMostRecentMoviesLiveData.observe(viewLifecycleOwner) {
                binding.rvTopMovies.adapter = it.body()?.let { it1 -> TopMoviesAdapter(it1) }
            }
        }


        lifecycleScope.launch {
            viewModel.getMostRecentMoviesLiveData.observe(viewLifecycleOwner) {list->
                binding.rvMostRecentMovies.adapter = list.body()?.let { it1 -> MoviesAdapter(it1.reversed(),false) }
                binding.tvMostRecentViewAll.setOnClickListener{toExpandedMovies(list)}
            }
        }


        lifecycleScope.launch {
            viewModel.getActorsLiveData.observe(viewLifecycleOwner) {list->
                binding.rvActorsMovies.adapter= list.body()?.let { it1 -> ActorsAdapter(it1,false) }
                binding.tvActorsViewAll.setOnClickListener{toExpandedActors(list)}
            }

        }


    }

    private fun toExpandedMovies(list:Response<List<MoviesModel>>)
    {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToExpandedMoviesFragment(
                "Most Recent",
                list.body()!!.toTypedArray()
            )
        )
    }
    private fun toExpandedActors(list:Response<List<ActorModel>>)
    {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToExpandedActorsFragment(
                list.body()!!.toTypedArray()
            )
        )
    }

}