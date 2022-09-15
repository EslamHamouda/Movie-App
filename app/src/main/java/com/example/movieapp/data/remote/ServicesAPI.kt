package com.example.movieapp.data.remote

import com.example.movieapp.auth.data.LoginResponse
import com.example.movieapp.auth.data.RegisterRequest
import com.example.movieapp.auth.data.RegisterResponse
import com.example.movieapp.home.data.ActorModel
import com.example.movieapp.home.data.MoviesModel
import retrofit2.Response
import retrofit2.http.*

interface ServicesAPI {

    @FormUrlEncoded
    @POST("login")
    suspend fun login(@FieldMap params: Map<String, String>): Response<LoginResponse>

    @POST("user/register")
    suspend fun register(@Body requestBody: RegisterRequest): Response<RegisterResponse>

    @GET("actor/getActors")
    suspend fun getActors(): Response<List<ActorModel>>

    @GET("movies/movieList")
    suspend fun getTopMovies(): Response<List<MoviesModel>>

    @GET("movies/name/{name}")
    suspend fun getMovieName(@Path("name")para:String): Response<List<MoviesModel>>





}