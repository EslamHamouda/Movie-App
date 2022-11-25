package com.example.movieapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.repository.DetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(val repository: DetailsRepository): ViewModel() {

    fun rate(mId:Int,uId:Int,rate:Int) =
        viewModelScope.launch {
            repository.rate(mId, uId, rate)
        }


}