package com.example.tvsconnectdemo.authentication.models

data class CountryListResponse(
    val Data: ArrayList<CountryDetail>,
    val Message: String?,
    val Result: String?,
    val StatusCode: Int?
)

data class CountryDetail(
    val AgeCheck: Any,
    val AndroidLanguageCode: String?,
    val AzureBLOBContainer: String?,
    val CountryId: String?,
    val IsSMSEnabled: String?,
    val IsSMSOTPMandatory: String?,
    val LanguageCode: String?,
    val Name: String?,
    val Region: String?,
    val WebViewLanguageCode: String?,
    val iOSAppLanguageCode: String?,
    val iOSHereMapLanguageCode: String?
)

data class CountryDataModel(
    var country: String = "",
    var countryCode: String = "",
    var languageCode: String = "",
    var androidLangCode: String = "",
    var webLanguageCode: String = "",
    var countryId: String = "",
    var isSmsOtpMandatory: String = "",
    var region: String = "",
    var isSMSEnabled: String = "",
    var isSMSOTPMandatory: String = ""
)


data class CommonResponse(
    val Message: String? = null,
    val Version: String? = null,
    val StatusCode: Int = 0,
    val Result: String? = null,
    val Data: Any? = null
)