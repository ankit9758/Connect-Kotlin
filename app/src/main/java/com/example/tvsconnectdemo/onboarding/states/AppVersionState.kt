package com.example.tvsconnectdemo.onboarding.states

import com.example.tvsconnectdemo.authentication.models.AppVersion

sealed class AppVersionState {
    object ShowLoading:AppVersionState()
    object Idle:AppVersionState()
    class Success(val data: AppVersion) : AppVersionState()
    class Error(val throwable: Throwable) : AppVersionState()
}