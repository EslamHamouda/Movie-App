package com.example.movieapp.details.ui

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.MediaController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentDetailsBinding
import java.text.SimpleDateFormat
import java.util.*


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

        setMovieDetails()
        binding.arrowBack.setOnClickListener{goHome()}
    }

    private fun goHome(){
        findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToHomeFragment())
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setMovieDetails(){

        binding.videoView.webViewClient= WebViewClient()
        binding.videoView.webChromeClient= WebChromeClient()
        args.item.video?.let { binding.videoView.loadUrl(it) }
        binding.videoView.settings.javaScriptEnabled=true
        binding.videoView.settings.pluginState=WebSettings.PluginState.ON

        binding.tvMovieName.text=args.item.movieName
        binding.tvMovieRating.text= (1..5).random().toString()
        binding.tvDirectorName.text=args.item.directorName
        val time=args.item.time
        binding.tvMovieTime.text = "${time?.div(60)}h ${time?.mod(60)}m"
        binding.tvCategoryName.text=args.item.category
        binding.tvMovieYear.text= args.item.releasedYear.toString()
        binding.tvMovieDescription.text=args.item.description
    }

}