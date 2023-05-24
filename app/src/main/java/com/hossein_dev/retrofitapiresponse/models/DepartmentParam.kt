package com.hossein_dev.retrofitapiresponse.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DepartmentParam(
    @SerializedName("UserCode")
    var userCode: Int = 0,
): Serializable
