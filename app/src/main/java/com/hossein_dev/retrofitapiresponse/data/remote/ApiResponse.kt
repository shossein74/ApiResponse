package com.hossein_dev.retrofitapiresponse.data.remote

import com.google.gson.annotations.SerializedName

sealed class ApiResponse<T> (
    @SerializedName("StatusCode")
    var statusCode : Int = 0,
    @SerializedName("Message")
    var message: String? = null,
    @SerializedName("Result")
    var result: T? = null
){
    class Success<T>(message: String?, result: T) : ApiResponse<T>(200,message, result)
    class Failure<T>(statusCode: Int, message: String? = "") : ApiResponse<T>(statusCode, message)
    class Loading<T>() : ApiResponse<T>()
    class EmptyState<T>() : ApiResponse<T>()
}