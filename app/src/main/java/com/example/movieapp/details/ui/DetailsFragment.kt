package com.example.movieapp.details.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    lateinit var binding:FragmentDetailsBinding
    val args:DetailsFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mediaController=MediaController(requireContext())
        binding.videoView.setVideoURI(Uri.parse("https://static.videezy.com/system/resources/previews/000/055/404/original/200921-LoopGreenLightPatternGrid.mp4"))
        binding.videoView.setMediaController(mediaController)
        binding.videoView.start()
        binding.tvMovieName.text=args.item.title
        binding.tvMovieRating.text= "4.5"
        binding.tvDirectorName.text="William Charlly"
        binding.tvMovieTime.text="1h 30m"
        binding.tvCategoryName.text="Action"
        binding.tvMovieYear.text="Aug 2018"
        binding.tvMovieDescription.text="The Hobbit: The Battle of the Five Armies is a 2014 epic high fantasy adventure film directed by Peter Jackson from a screenplay by Fran Walsh, Philippa Boyens, Jackson, and Guillermo del Toro, based on the 1937 novel The Hobbit by J. R. R. Tolkien. The sequel to The Hobbit: The Desolation of Smaug (2013), it is the final instalment in The Hobbit trilogy, acting as a prequel to Jackson's The Lord of the Rings trilogy."

        binding.arrowBack.setOnClickListener{goHome()}
    }

    private fun goHome(){
        findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToHomeFragment())
    }

}