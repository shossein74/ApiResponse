package com.hossein_dev.retrofitapiresponse.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitapiresponse.R
import com.example.retrofitapiresponse.databinding.ActivityLoginBinding
import com.hossein_dev.retrofitapiresponse.data.remote.ApiResponse
import com.hossein_dev.retrofitapiresponse.models.LoginParam
import com.hossein_dev.retrofitapiresponse.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val mainVM by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainVM.loginLiveData.observe(this) { response ->
            when (response) {
                is ApiResponse.Loading -> {
                    //show loading state
                }

                is ApiResponse.Success -> {
                    // login success
                }

                is ApiResponse.Failure -> {
                    // show error alert
                }

                else -> {}
            }
        }

        binding.btnLogin.setOnClickListener {
            binding.apply {
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()
                if (username.isNotEmpty() && password.isNotEmpty()) {
                    //create param model and calling login api
                    val loginParam = LoginParam(username, password)
                    mainVM.login(loginParam)
                }
            }
        }
    }
}