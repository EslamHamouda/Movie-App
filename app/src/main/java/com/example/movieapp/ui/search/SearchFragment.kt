package com.example.movieapp.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.movieapp.databinding.FragmentSearchBinding
import com.example.movieapp.ui.adapter.MoviesSearchAdapter
import com.example.movieapp.ui.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment() {
    lateinit var binding:FragmentSearchBinding
    //lateinit var adabter:MoviesSearchAdapter
    val viewModel: SearchViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      //  adabter=MoviesSearchAdapter(DataSource.getMovies())
        //binding.rvSearchResult.adapter=adabter

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                if(query!="") {
                    viewModel.getMovieName(query!!)
                    lifecycleScope.launch {
                        viewModel.getMovieNameLiveData.observe(viewLifecycleOwner) {list->
                            binding.rvSearchResult.adapter = list.body()?.let { it1 -> MoviesSearchAdapter(it1) }
                            binding.tvNumberOfItems.text = "${list.body()?.size} movies available"
                        }
                    }
                }
                else{

                    binding.tvNumberOfItems.text = "0 movies available"
                }
                return true
            }

        })
    }

}