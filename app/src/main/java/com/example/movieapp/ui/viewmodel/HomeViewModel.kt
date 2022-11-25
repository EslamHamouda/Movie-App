package com.example.movieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.models.response.ActorModel
import com.example.movieapp.data.repository.HomeRepository
import com.example.movieapp.data.models.response.MoviesModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val repository: HomeRepository): ViewModel() {

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