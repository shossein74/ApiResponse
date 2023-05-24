package com.hossein_dev.retrofitapiresponse.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hossein_dev.retrofitapiresponse.data.remote.ApiResponse
import com.hossein_dev.retrofitapiresponse.data.remote.HandleApiResponse
import com.hossein_dev.retrofitapiresponse.models.DepartmentParam
import com.hossein_dev.retrofitapiresponse.models.DepartmentResponse
import com.hossein_dev.retrofitapiresponse.models.LoginParam
import com.hossein_dev.retrofitapiresponse.models.LoginResponse
import com.hossein_dev.retrofitapiresponse.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository): ViewModel() {

    private val _login = MutableLiveData<ApiResponse<LoginResponse>>()
    val loginLiveData get() = _login

    private val _department = MutableLiveData<ApiResponse<List<DepartmentResponse>>>()
    val departmentLiveData get() = _department

    fun login(param: LoginParam) {
        viewModelScope.launch(Dispatchers.IO) {
            _login.postValue(ApiResponse.Loading())

            val response = HandleApiResponse.handleWithApiResponse { repository.login(param) }
            _login.postValue(response)
        }
    }

    fun getDepartmentList(param: DepartmentParam) {
        viewModelScope.launch(Dispatchers.IO) {
            _department.postValue(ApiResponse.Loading())

            val response = HandleApiResponse.handleWithApiResponse { repository.getDepartmentList(param) }
            _department.postValue(response)
        }
    }
}