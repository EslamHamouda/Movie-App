package com.example.movieapp.auth.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.auth.data.AuthRepository
import com.example.movieapp.auth.data.LoginResponse
import com.example.movieapp.auth.data.RegisterRequest
import com.example.movieapp.auth.data.RegisterResponse
import com.example.movieapp.data.remote.NetworkModule
import com.example.movieapp.home.data.ActorModel
import com.example.movieapp.home.data.HomeRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class AuthViewModel:ViewModel() {

    private var repository: AuthRepository
    init {
        val services = NetworkModule().userServices()
        repository= AuthRepository(services)
    }

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