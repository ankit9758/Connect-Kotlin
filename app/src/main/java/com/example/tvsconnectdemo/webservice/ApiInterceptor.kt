package com.example.tvsconnectdemo.webservice

import com.example.tvsconnectdemo.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // Modify the request or handle authentication/logic here
        val originalRequest = chain.request()

        // Example: Adding an API key header
        val modifiedRequest = originalRequest.newBuilder()
            .header("appVersion-android", BuildConfig.VERSION_NAME)
            .build()

        return chain.proceed(modifiedRequest)
    }
}
