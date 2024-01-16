package com.example.tvsconnectdemo.authentication.models

import com.example.tvsconnectdemo.utils.KEYS

data class NewLoginReq(
    var mobileNumber: String? = null,
    var Email: String? = null,
    var CountryCode: Int = KEYS.COUNTRYCODE,
    var FacebookId: String? = null,
    var GoogleplusId: String? = null,
    var androidToken: String? = null,
    var otpLength: Int = KEYS.OTP_LENGTH,
    var deviceType: String = "android",
    var PublicKey: String? = null
)