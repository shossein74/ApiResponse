package com.hossein_dev.retrofitapiresponse.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginResponse(
    @SerializedName("Code")
    var code: Int,
    @SerializedName("Name")
    var name: String,
    @SerializedName("IsActive")
    var isActive: Boolean,
    @SerializedName("UserType")
    var karbarType: Int,
): Serializable
