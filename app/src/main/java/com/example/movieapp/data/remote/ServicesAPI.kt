package com.example.movieapp.data.remote

import com.example.movieapp.home.data.ActorModel
import retrofit2.Response
import retrofit2.http.GET

interface ServicesAPI {

    @GET("actor/getActors")
    suspend fun getActors(): Response<List<ActorModel>>

}