package com.example.tvsconnectdemo.authentication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvsconnectdemo.authentication.models.CommonResponse
import com.example.tvsconnectdemo.authentication.models.CountryListResponse
import com.example.tvsconnectdemo.authentication.models.NewLoginReq
import com.example.tvsconnectdemo.authentication.repository.AuthRepository
import com.example.tvsconnectdemo.authentication.states.CountryListState
import com.example.tvsconnectdemo.authentication.states.LoginState
import com.example.tvsconnectdemo.onboarding.models.AppVersion
import com.example.tvsconnectdemo.onboarding.states.AppVersionState
import com.example.tvsconnectdemo.webservice.ResultHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val repository: AuthRepository) :
    ViewModel() {
    private val _countryListState = MutableStateFlow<CountryListState>(CountryListState.Idle)
    val countryListState = _countryListState.asStateFlow()

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState = _loginState.asStateFlow()

  /*  fun getCityList() {
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


*/

  fun getCountryList() {
      _countryListState.value = CountryListState.ShowLoading
      viewModelScope.launch {
          when (val res = repository.getCountryList()) {
              is ResultHandler.Error -> {
                  _countryListState.value = CountryListState.Error(res.throwable)
              }
              is ResultHandler.Success -> {
                  val response = (res.data as Response<*>)
                  if (response.isSuccessful) {
                      val data = res.data.body() as CountryListResponse
                      _countryListState.value = CountryListState.Success(data)
                  } else {
                      _countryListState.value =
                          CountryListState.Error(Throwable(("Something went wrong.")))
                  }

              }
          }
      }

  }

    fun callLoginApi(loginReq: NewLoginReq) {
        _loginState.value = LoginState.ShowLoading
        viewModelScope.launch {
            when (val res = repository.callLoginApi(loginReq)) {
                is ResultHandler.Error -> {
                    _loginState.value = LoginState.Error(res.throwable)
                }
                is ResultHandler.Success -> {
                    val response = (res.data as Response<*>)
                    if (response.isSuccessful) {
                        val data = res.data.body() as CommonResponse?
                        _loginState.value = LoginState.Success(data)
                    } else {
                        _loginState.value =
                            LoginState.Error(Throwable(("Something went wrong.")))
                    }

                }
            }
        }

    }
}