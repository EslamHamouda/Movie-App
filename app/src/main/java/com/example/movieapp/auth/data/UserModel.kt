package com.example.movieapp.auth.data

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("access_token") var token: String?,
    @SerializedName("username") var username: String = "Guest",
    @SerializedName("email") var email: String?,
    @SerializedName("user_id") var userId: Int?,
    @SerializedName("mobile") var mobile: String?
) {
    companion object {
        val currentUser = UserModel(
            token = null,
            email = null,
            userId = null,
            mobile = null
        )
    }
}