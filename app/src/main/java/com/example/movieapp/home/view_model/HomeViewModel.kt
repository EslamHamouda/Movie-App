package com.example.movieapp.home.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.remote.NetworkModule
import com.example.movieapp.home.data.ActorModel
import com.example.movieapp.home.data.HomeRepository
import com.example.movieapp.home.data.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response


class HomeViewModel: ViewModel() {
    private var repository:HomeRepository
    init {
        val services =NetworkModule().userServices()
        repository= HomeRepository(services)
    }

    val getActorsLiveData=MutableLiveData<Response<List<ActorModel>>>()

    fun getActors() {
        viewModelScope.launch {
            getActorsLiveData.value = repository.getActors() as Response<List<ActorModel>>
        }
    }

    val getMostRecentMoviesLiveData=MutableLiveData<Response<List<MoviesModel>>>()

    fun getTopMovies() {
        viewModelScope.launch {
            getMostRecentMoviesLiveData.value = repository.getTopMovies() as Response<List<MoviesModel>>
        }
    }


}