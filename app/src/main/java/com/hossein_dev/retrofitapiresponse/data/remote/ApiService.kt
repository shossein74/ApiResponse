package com.hossein_dev.retrofitapiresponse.data.remote

import com.hossein_dev.retrofitapiresponse.models.DepartmentParam
import com.hossein_dev.retrofitapiresponse.models.DepartmentResponse
import com.hossein_dev.retrofitapiresponse.models.LoginParam
import com.hossein_dev.retrofitapiresponse.models.LoginResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("Api/Common/Users/Login")
    suspend fun login(
        @Header("ApiKey") apiKey: String, @Body param: LoginParam
    ): Response<ApiResponse<LoginResponse>>

    @Headers("content-type: application/json")
    @POST("api/Common/Department/UserDepartmentList")
    suspend fun getDepartmentList(
        @Header("ApiKey") apiKey: String, @Body param: DepartmentParam
    ): Response<ApiResponse<List<DepartmentResponse>>>
}