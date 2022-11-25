package com.example.movieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.models.response.MoviesModel
import com.example.movieapp.data.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(val repository: SearchRepository):ViewModel() {

    val getMovieNameLiveData= MutableLiveData<Response<List<MoviesModel>>>()

    fun getMovieName(para:String) {
        viewModelScope.launch {
            getMovieNameLiveData.value = repository.getMovieName(para) as Response<List<MoviesModel>>
        }
    }
}