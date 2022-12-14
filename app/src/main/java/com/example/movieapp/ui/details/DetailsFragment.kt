package com.example.movieapp.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.RatingBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.movieapp.databinding.FragmentDetailsBinding
import com.example.movieapp.ui.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    lateinit var binding:FragmentDetailsBinding
    val args: DetailsFragmentArgs by navArgs()
    val viewModel: DetailsViewModel by viewModels()

    var userRate= -1
    var flag=false

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


        binding.userRating.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
                flag=true
                userRate= rating.toInt()
            }

        binding.btnRate.setOnClickListener {
            if (flag) {
                rate(userRate)
                Toast.makeText(requireContext(),"Thanks for your rating!",Toast.LENGTH_SHORT).show()

            }else Toast.makeText(requireContext(),"Rate first!",Toast.LENGTH_SHORT).show()
        }
    }

    private fun goHome(){
        findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToHomeFragment())
    }

    private fun rate(rating:Int){
        val uId=requireActivity().getSharedPreferences("uId",0).getInt("id",-1)
        viewModel.rate(args.item.movieId!!,uId,rating)
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