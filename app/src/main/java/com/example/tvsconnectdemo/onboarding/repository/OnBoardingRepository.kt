package com.example.tvsconnectdemo.onboarding.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tvsconnectdemo.authentication.models.AppVersion
import com.example.tvsconnectdemo.authentication.network.APIService
import com.example.tvsconnectdemo.webservice.ResultHandler
import com.example.tvsconnectdemo.webservice.runIO
import javax.inject.Inject

class OnBoardingRepository @Inject constructor(private val apiService: APIService) {

    private val _appVersion= MutableLiveData<AppVersion>()
    val appVersion: LiveData<AppVersion>
        get() = _appVersion

    suspend fun getAppVersion(): ResultHandler<Any> {
        return runIO { apiService.getAppVersion() }
    }
}