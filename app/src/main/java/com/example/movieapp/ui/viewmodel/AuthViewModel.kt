package com.example.movieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.repository.AuthRepository
import com.example.movieapp.data.models.response.LoginResponse
import com.example.movieapp.data.models.request.RegisterRequest
import com.example.movieapp.data.models.response.RegisterResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(val repository: AuthRepository) :ViewModel() {

    val loginResponse= MutableLiveData<Response<LoginResponse>>()

    fun login(map:Map<String,String>) {
        viewModelScope.launch {
            loginResponse.value = repository.login(map) as Response<LoginResponse>
        }
    }

    val registerResponse= MutableLiveData<Response<RegisterResponse>>()

    fun register(registerRequest: RegisterRequest) {
        viewModelScope.launch {
            registerResponse.value = repository.register(registerRequest) as Response<RegisterResponse>
        }
    }

}