package com.hossein_dev.retrofitapiresponse.repository

import com.hossein_dev.retrofitapiresponse.data.remote.ApiConstants
import com.hossein_dev.retrofitapiresponse.data.remote.ApiService
import com.hossein_dev.retrofitapiresponse.models.DepartmentParam
import com.hossein_dev.retrofitapiresponse.models.LoginParam
import javax.inject.Inject

class MainRepository @Inject constructor(private val api: ApiService) {

    suspend fun login(param: LoginParam) =
        api.login(ApiConstants.COMMON_API_PASS, param)

    suspend fun getDepartmentList(param: DepartmentParam) =
        api.getDepartmentList(ApiConstants.COMMON_API_PASS, param)
}