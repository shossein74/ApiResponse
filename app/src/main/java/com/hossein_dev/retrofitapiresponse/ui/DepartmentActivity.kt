package com.hossein_dev.retrofitapiresponse.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitapiresponse.databinding.ActivityDepartmentBinding
import com.hossein_dev.retrofitapiresponse.data.remote.ApiResponse
import com.hossein_dev.retrofitapiresponse.models.DepartmentParam
import com.hossein_dev.retrofitapiresponse.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DepartmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDepartmentBinding

    private val mainVM by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDepartmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainVM.departmentLiveData.observe(this) { response ->
            when (response) {
                is ApiResponse.Loading -> {

                }
                is ApiResponse.Success -> {

                }
                is ApiResponse.EmptyState -> {

                }
                is ApiResponse.Failure -> {

                }
            }
        }

        val param = DepartmentParam(/*login user code */)
        mainVM.getDepartmentList(param)

    }

}