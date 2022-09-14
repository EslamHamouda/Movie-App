package com.example.movieapp.search.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.example.movieapp.databinding.FragmentSearchBinding
import com.example.movieapp.home.data.DataSource

class SearchFragment : Fragment() {
    lateinit var binding:FragmentSearchBinding
    lateinit var adabter:MoviesSearchAdapter
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
        adabter=MoviesSearchAdapter(DataSource.getMovies())
        binding.rvSearchResult.adapter=adabter

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                if(query!="") {
                    adabter.changeList(query)
                    binding.tvNumberOfItems.text = "${adabter.itemCount} records available"
                }
                else{
                    adabter.setEmpty()
                    binding.tvNumberOfItems.text = "0 records available"
                }
                return true
            }

        })
    }

}