package com.hossein_dev.retrofitapiresponse.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DepartmentResponse(
    @SerializedName("Code")
    var code: Int = 0,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("IsActive")
    val IsActive: Boolean = false
): Serializable
