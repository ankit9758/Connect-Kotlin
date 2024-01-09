package com.example.tvsconnectdemo.authentication.network

import com.example.tvsconnectdemo.authentication.models.AppVersion
import com.example.tvsconnectdemo.webservice.ApiConstant
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET(ApiConstant.GET_APP_VERSION)
    suspend fun getAppVersion(): Response<AppVersion>
}