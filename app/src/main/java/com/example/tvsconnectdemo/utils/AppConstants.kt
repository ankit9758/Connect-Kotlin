package com.example.tvsconnectdemo.utils

object AppConstants {
    const val YYYY_MM_DD_T_HH_MM_SS = "yyyy-MM-dd'T'hh:mm:ss"

    const val EEE_DD_MMM_YYYY = "EEE, dd MMM yyyy"

    const val WIP_STATUS_UNALLOCATED = "0"
    const val WIP_STATUS_ALLOCATED = "1"
    const val WIP_STATUS_SUSPENDED = "2"
    const val WIP_STATUS_INVOICED = "4"
    const val WIP_STATUS_COMPLETED = "5"


    const val HOME = "Home"
    const val WORK = "Work"
    const val GYM = "Gym"
    const val COLLEGE = "College"
    const val LOCATION = "Location"

    const val LABEL_MICROPHONE = "Microphone"

    const val MA_BASE_URL = "https://www.tvsmotor.com/en/shop/"
    const val MERCHANDISE_ACTION = "merchandise"
    const val ACCESSORIES_ACTION = "accessories"

    const val SMS_OTP_ZERO = "0"

    const val GOOGLE_PHOTO_URI = "com.google.android.apps.photos.content"
    const val MEDIA_DOCUMENT_URI = "com.android.providers.media.documents"
    const val DOWNLOAD_DOCUMENT_URI = "com.android.providers.downloads.documents"
    const val EXTERNAL_STORAGE_DOCUMENT_URI = "com.android.externalstorage.documents"
    const val CONTENT_URI = "content://downloads/public_downloads"

    var loginEmail = ""
    var loginSelectedCountryId = 0
    const val BANGLADESH = "Bangladesh"
    const val SRI_LANKA = "Sri Lanka"
    const val NEPAL = "Nepal"
    const val MAX_SMS_COUNT = 99

    fun clearLoginTempValues() {
        loginEmail = ""
        loginSelectedCountryId = 0
    }

    var signUpSelectedCountryId = 0
    var signUpName = ""
    var signUpMobile = ""
    var signUpEmail = ""
    var signUpCity = ""
    var signUpTermsCheckTemp = false
    var signUpMarketConsentTemp = false

    fun clearSignUpTempValues() {
        signUpSelectedCountryId = 0
        signUpName = ""
        signUpMobile = ""
        signUpEmail = ""
        signUpCity = ""
        signUpTermsCheckTemp = false
        signUpMarketConsentTemp = false
    }

    var STR_TO_HEX_FORMAT = "0x%02x"
}