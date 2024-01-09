package com.example.tvsconnectdemo.authentication.models

data class AppVersion(
    var StatusCode: Int?,
    var Message: String?,
    var Result: String?,
    var Data: ArrayList<AppVersionData> = arrayListOf()
)

data class AppVersionData(
    var iosAppVersionId: Boolean?,
    var androidAppVersionId: String?,
    var androidForcefullyupdate: Boolean?,
    var CreatedDate: String?,
    var ClientSecretLastUpdatedDate: String?,
    var forceUpdate: String?,
    var softUpdate: String?
)