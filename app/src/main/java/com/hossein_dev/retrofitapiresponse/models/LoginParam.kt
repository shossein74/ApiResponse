package com.hossein_dev.retrofitapiresponse.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginParam(
    @SerializedName("Username")
    val username: String,
    @SerializedName("Password")
    val password: String,
): Serializable