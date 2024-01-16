package com.example.tvsconnectdemo.authentication.states

import com.example.tvsconnectdemo.authentication.models.CommonResponse

sealed class LoginState{
    object ShowLoading: LoginState()
    object Idle: LoginState()
    class Success(val data: CommonResponse?) : LoginState()
    class Error(val throwable: Throwable) : LoginState()
}
