package com.example.tvsconnectdemo.authentication.states

import com.example.tvsconnectdemo.authentication.models.CountryListResponse

sealed class CountryListState{
    object ShowLoading: CountryListState()
    object Idle: CountryListState()
    class Success(val data: CountryListResponse) : CountryListState()
    class Error(val throwable: Throwable) : CountryListState()
}
