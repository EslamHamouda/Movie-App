package com.example.movieapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.movieapp.databinding.FragmentExpandedActorsBinding
import com.example.movieapp.ui.adapter.ActorsAdapter


class ExpandedActorsFragment : Fragment() {
    lateinit var binding: FragmentExpandedActorsBinding
    val args: ExpandedActorsFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentExpandedActorsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvExpandedActorList.adapter= ActorsAdapter(args.list.asList(),true)
        binding.arrowBack.setOnClickListener{goHome()}
    }
    private fun goHome(){
        findNavController().navigate(ExpandedActorsFragmentDirections.actionExpandedActorsFragmentToHomeFragment())
    }


}