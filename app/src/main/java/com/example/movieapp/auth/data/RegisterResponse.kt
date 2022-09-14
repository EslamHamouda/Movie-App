package com.example.movieapp.auth.data

import com.google.gson.annotations.SerializedName

data class RegisterResponse(@SerializedName("id"                    ) var id                    : Int?     = null,
                            @SerializedName("email"                 ) var email                 : String?  = null,
                            @SerializedName("password"              ) var password              : String?  = null,
                            @SerializedName("mobile"                ) var mobile                : String?  = null,
                            @SerializedName("enabled"               ) var enabled               : Boolean? = null,
                            @SerializedName("username"              ) var username              : String?  = null,
                            @SerializedName("authorities"           ) var authorities           : String?  = null,
                            @SerializedName("accountNonExpired"     ) var accountNonExpired     : Boolean? = null,
                            @SerializedName("accountNonLocked"      ) var accountNonLocked      : Boolean? = null,
                            @SerializedName("credentialsNonExpired" ) var credentialsNonExpired : Boolean? = null)
