package com.example.movieapp.auth.data

import com.google.gson.annotations.SerializedName

data class RegisterRequest( @SerializedName("userName" ) var userName : String? = null,
                            @SerializedName("email"    ) var email    : String? = null,
                            @SerializedName("password" ) var password : String? = null,
                            @SerializedName("mobile"   ) var mobile   : String? = null
)
