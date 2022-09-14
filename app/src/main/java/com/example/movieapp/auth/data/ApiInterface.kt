package com.example.movieapp.auth.data

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    fun login(@FieldMap params: HashMap<String?, String?>): Call<UserModel>

    @POST("user/register")
    fun register(@Body requestBody: RequestBody): Call<UserModel>

    companion object {
//        const val IMAGE_URL: String = "https://image.tmdb.org/t/p/w185"
//        const val COVER_URL: String = "https://image.tmdb.org/t/p/w780"
        private const val BASE_URL = "https://banqmisrproject.herokuapp.com/"

        fun create(): ApiInterface {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build().create(ApiInterface::class.java)
        }
    }
}