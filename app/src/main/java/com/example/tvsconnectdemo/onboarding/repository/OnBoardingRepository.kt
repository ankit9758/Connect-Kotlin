package com.example.tvsconnectdemo.onboarding.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tvsconnectdemo.onboarding.models.AppVersion
import com.example.tvsconnectdemo.authentication.network.APIService
import com.example.tvsconnectdemo.onboarding.models.ViewPagerData
import com.example.tvsconnectdemo.onboarding.models.itemDataList
import com.example.tvsconnectdemo.onboarding.states.DataState
import com.example.tvsconnectdemo.webservice.ResultHandler
import com.example.tvsconnectdemo.webservice.runIO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class OnBoardingRepository @Inject constructor(private val apiService: APIService) {

    private val _appVersion= MutableLiveData<AppVersion>()
    val appVersion: LiveData<AppVersion>
        get() = _appVersion

    suspend fun getAppVersion(): ResultHandler<Any> {
        return runIO { apiService.getAppVersion() }
    }

    fun fetchAllOnBoardingData(): Flow<DataState<List<ViewPagerData>>> = flow {
        try {
            emit(DataState.Success(itemDataList))
        } catch (e: Exception) {
            emit(DataState.Error(Exception(e.localizedMessage)))
        }
    }.flowOn(Dispatchers.IO)
}