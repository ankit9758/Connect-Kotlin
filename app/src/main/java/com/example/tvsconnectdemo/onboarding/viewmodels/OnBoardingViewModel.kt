package com.example.tvsconnectdemo.onboarding.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvsconnectdemo.onboarding.models.AppVersion
import com.example.tvsconnectdemo.onboarding.models.ViewPagerData
import com.example.tvsconnectdemo.onboarding.repository.OnBoardingRepository
import com.example.tvsconnectdemo.onboarding.states.AppVersionState
import com.example.tvsconnectdemo.onboarding.states.DataState
import com.example.tvsconnectdemo.webservice.ResultHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val repository: OnBoardingRepository) :
    ViewModel() {

    private val _appVersionState = MutableStateFlow<AppVersionState>(AppVersionState.Idle)
    val appVersionState = _appVersionState.asStateFlow()

    private val _pagerDataList = MutableLiveData<DataState<List<ViewPagerData>>>()
    val pagerDataList: LiveData<DataState<List<ViewPagerData>>>
        get() = _pagerDataList


     fun getProductList() {
        _appVersionState.value = AppVersionState.ShowLoading
        viewModelScope.launch {
            when (val res = repository.getAppVersion()) {
                is ResultHandler.Error -> {
                    _appVersionState.value = AppVersionState.Error(res.throwable)
                }
                is ResultHandler.Success -> {
                    val response = (res.data as Response<*>)
                    if (response.isSuccessful) {
                        val data = res.data.body() as AppVersion
                        _appVersionState.value = AppVersionState.Success(data)
                    } else {
                        _appVersionState.value =
                            AppVersionState.Error(Throwable(("Something went wrong.")))
                    }

                }
            }
        }

    }

     fun fetchAllOnBoardingData() {
        viewModelScope.launch {
            repository.fetchAllOnBoardingData()
                .onEach {
                    _pagerDataList.value = it
                }.launchIn(viewModelScope)
        }
    }
}