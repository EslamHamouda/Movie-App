package com.example.movieapp.search.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.remote.NetworkModule
import com.example.movieapp.home.data.HomeRepository
import com.example.movieapp.home.data.MoviesModel
import com.example.movieapp.search.data.SearchRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class SearchViewModel:ViewModel() {

    private var repository: SearchRepository
    init {
        val services = NetworkModule().userServices()
        repository= SearchRepository(services)
    }

    val getMovieNameLiveData= MutableLiveData<Response<List<MoviesModel>>>()

    fun getMovieName(para:String) {
        viewModelScope.launch {
            getMovieNameLiveData.value = repository.getMovieName(para) as Response<List<MoviesModel>>
        }
    }
}