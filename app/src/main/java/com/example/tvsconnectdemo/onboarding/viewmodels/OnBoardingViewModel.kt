package com.example.tvsconnectdemo.onboarding.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvsconnectdemo.authentication.models.AppVersion
import com.example.tvsconnectdemo.onboarding.repository.OnBoardingRepository
import com.example.tvsconnectdemo.onboarding.states.AppVersionState
import com.example.tvsconnectdemo.webservice.ResultHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject
@HiltViewModel
class OnBoardingViewModel @Inject constructor(private  val repository: OnBoardingRepository) : ViewModel(){

        private val _appVersionState= MutableStateFlow<AppVersionState>(AppVersionState.Idle)
        val appVersionState=_appVersionState.asStateFlow()

        init {
            getProductList()
        }

        fun getProductList() {
            _appVersionState.value=AppVersionState.ShowLoading
            viewModelScope.launch {
                when(val res = repository.getAppVersion()){
                    is ResultHandler.Error -> {
                        _appVersionState.value=AppVersionState.Error(res.throwable)
                    }
                    is ResultHandler.Success -> {
                        val response= (res.data as Response<*>)
                        if(response.isSuccessful){
                            val data= res.data.body()  as AppVersion
                            _appVersionState.value =AppVersionState.Success(data)
                        }else{
                            _appVersionState.value= AppVersionState.Error(Throwable(("Something went wrong.")))
                        }

                    }
                }
            }

        }

    }