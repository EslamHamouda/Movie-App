package com.example.movieapp.home.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.remote.NetworkModule
import com.example.movieapp.details.data.DetailsRepository
import com.example.movieapp.home.data.ActorModel
import com.example.movieapp.home.data.HomeRepository
import com.example.movieapp.home.data.MoviesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


class DetailsViewModel: ViewModel() {
    private var repository:DetailsRepository
    init {
        val services =NetworkModule().userServices()
        repository= DetailsRepository(services)
    }

    fun rate(mId:Int,uId:Int,rate:Int) =
        viewModelScope.launch {
            repository.rate(mId, uId, rate)
        }


}