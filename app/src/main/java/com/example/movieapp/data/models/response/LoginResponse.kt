package com.example.movieapp.data.models.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(@SerializedName("access_token" ) var accessToken : String? = null,
                         @SerializedName("username"     ) var username    : String? = null,
                         @SerializedName("email"        ) var email       : String? = null,
                         @SerializedName("mobile"       ) var mobile      : String? = null,
                         @SerializedName("user_id"      ) var userId      : Int?    = null,
                         @SerializedName("expire"       ) var expire      : Int?    = null)
