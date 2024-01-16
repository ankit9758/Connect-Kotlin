package com.example.tvsconnectdemo.authentication.network

import com.example.tvsconnectdemo.authentication.models.CommonResponse
import com.example.tvsconnectdemo.authentication.models.CountryListResponse
import com.example.tvsconnectdemo.authentication.models.NewLoginReq
import com.example.tvsconnectdemo.onboarding.models.AppVersion
import com.example.tvsconnectdemo.webservice.ApiConstant
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {
    @GET(ApiConstant.GET_APP_VERSION)
    suspend fun getAppVersion(): Response<AppVersion>

    @GET(ApiConstant.GET_COUNTRY_LIST)
    suspend fun getCountryList(): Response<CountryListResponse>

    @POST(ApiConstant.LOGIN)
    suspend fun callLoginApi(@Body  newLoginReq: NewLoginReq): Response<CommonResponse>
}