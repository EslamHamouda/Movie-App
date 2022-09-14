package com.example.movieapp.data.remote

import android.content.SharedPreferences
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule {
    private val BASE_URL = "https://banqmisrproject.herokuapp.com/"

    private var retrofit: Retrofit? = null

    private fun getClient(): Retrofit? {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient()
        client.newBuilder().addInterceptor(interceptor).build()
        if (retrofit == null) {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
        }
        return retrofit
    }

    fun userServices(): ServicesAPI {
        return getClient()!!.create(ServicesAPI::class.java)
    }
}