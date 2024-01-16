package com.example.tvsconnectdemo.authentication.repository

import com.example.tvsconnectdemo.authentication.models.NewLoginReq
import com.example.tvsconnectdemo.authentication.network.APIService
import com.example.tvsconnectdemo.webservice.ResultHandler
import com.example.tvsconnectdemo.webservice.runIO
import javax.inject.Inject

class AuthRepository @Inject constructor(private val apiService: APIService) {
    suspend fun getCountryList(): ResultHandler<Any> {
        return runIO { apiService.getCountryList() }
    }

    suspend fun callLoginApi(loginReq: NewLoginReq): ResultHandler<Any> {
        return runIO { apiService.callLoginApi(loginReq) }
    }
}