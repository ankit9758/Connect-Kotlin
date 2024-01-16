package com.example.tvsconnectdemo.utils

import android.text.TextUtils
import com.example.tvsconnectdemo.BuildConfig
import java.io.File
import java.util.regex.Matcher
import java.util.regex.Pattern

object Validation {

    fun isValidName(userName: String?): Boolean {
        return !TextUtils.isEmpty(userName) && (userName!!.length >= 4 || userName.length <= 40)
    }

    fun isValidEmail(email: String?): Boolean {
        if (email == null) {
            return false
        }
        val emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        val pattern: Pattern = Pattern.compile(emailPattern)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun isValidYouttubeVideo(videoUrl: String?): Boolean {
        if (videoUrl == null) {
            return false
        }
        val emailPattern =AppConstants.VIDEO_REGEX
        val pattern: Pattern = Pattern.compile(emailPattern)
        val matcher: Matcher = pattern.matcher(videoUrl)
        return matcher.matches()
    }

    fun isValidMobile(phone: String?): Boolean {
        return android.util.Patterns.PHONE.matcher(phone).matches()
    }

    fun isCustomValidMobile(phone: String?): Boolean {
        var check = false
        check = if (BuildConfig.isIndia || AppSettings.isNepalApp() || AppSettings.isBangladeshApp() || AppSettings.isSriLankaApp())
            Pattern.matches("^[0-9]*$", phone) && phone!!.length == 10
        else {
            Pattern.matches("^[0-9]*$", phone)
        }
        return check
    }

    fun isValidMPIN(mPIN: String?): Boolean {
        return !TextUtils.isEmpty(mPIN) && mPIN!!.length == 4
    }

    fun isValidOTP(otp: String?): Boolean {
        return !TextUtils.isEmpty(otp) && otp!!.length == 4
    }

    fun isValidAddress(address: String?): Boolean {
        return !TextUtils.isEmpty(address)
    }

    fun isCityThreshold(cityName: String?): Boolean {
        return (!TextUtils.isEmpty(cityName) && cityName!!.length >= 3)
    }

    fun isValidImageSize(imagePath: String?): Boolean {
        return try {
            val img = File(imagePath!!)
            val length: Int = img.length().toInt()
            length <= 5000000
        } catch (e: Exception) {
            false
        }
    }

    fun isSpecialChar(s: String?): Boolean {
        return s?.contains("<") == true || s?.contains(">") == true || s?.contains("/") == true || s?.contains("\\") == true
    }

    fun isSpecialCharForW3W(s: String?): Boolean {
        return s?.contains("<") == true || s?.contains(">") == true || s?.contains("\\") == true
    }

    fun isValidMobileNumber(countryId: String, mobileDigit: Int): Boolean {
        var isValid = false
        if (BuildConfig.isIndia) {
            isValid = mobileDigit == 10
        } else if (AppSettings.isAfrica()) {
            isValid = mobileDigit == 10
        } else if (AppSettings.isMiddleEast()) {
            isValid = mobileDigit in 10..11
        } else if (AppSettings.isNepalApp()) {
            isValid = mobileDigit == 10
        } else {
            val countryMap: Map<String, ArrayList<Int>> = getListOfCountryMobileDigit()
            val mobileDigits: ArrayList<Int>? = countryMap[countryId]
            if (mobileDigits != null) {
                for (getMobileDigit: Int in mobileDigits) {
                    if (mobileDigit == getMobileDigit) {
                        isValid = true
                        break
                    }
                }
            } else {
                isValid = true
            }
        }
        return isValid
    }
    private fun getListOfCountryMobileDigit(): Map<String, java.util.ArrayList<Int>> {
        val pairWithCountry: MutableMap<String, java.util.ArrayList<Int>> = HashMap()
        val indonesia_list = java.util.ArrayList<Int>()
        indonesia_list.add(10)
        indonesia_list.add(11)
        indonesia_list.add(12)
        indonesia_list.add(13)
        indonesia_list.add(14)
        pairWithCountry["9"] = indonesia_list // Indonesia
        pairWithCountry["5"] = java.util.ArrayList(listOf(10))
        pairWithCountry["6"] = java.util.ArrayList(listOf(10))
        pairWithCountry["7"] = java.util.ArrayList(listOf(9))
        val mexico_list = java.util.ArrayList<Int>()
        mexico_list.add(10)
        mexico_list.add(11)
        mexico_list.add(12)
        mexico_list.add(13)
        pairWithCountry["8"] = mexico_list
        pairWithCountry["10"] = java.util.ArrayList(listOf(8))
        pairWithCountry["11"] = java.util.ArrayList(listOf(8))
        pairWithCountry["12"] = java.util.ArrayList(listOf(9))
        pairWithCountry["13"] = java.util.ArrayList(listOf(10))
        pairWithCountry["15"] = java.util.ArrayList(listOf(8))
        pairWithCountry["16"] = java.util.ArrayList(listOf(8))
        pairWithCountry["26"] = java.util.ArrayList(listOf(9))
        pairWithCountry["46"] = java.util.ArrayList(listOf(8))
        pairWithCountry["47"] = java.util.ArrayList(listOf(8))
        pairWithCountry["101"] = java.util.ArrayList(listOf(8))
        val brazil_list = java.util.ArrayList<Int>()
        brazil_list.add(10)
        brazil_list.add(11)
        pairWithCountry["102"] = brazil_list
        pairWithCountry["103"] = java.util.ArrayList(listOf(8))
        pairWithCountry["4"] =
            java.util.ArrayList(listOf(10)) //Bangladesh
        pairWithCountry["3"] =
            java.util.ArrayList(listOf(10)) //Sri lanka
        val venezuela_list = java.util.ArrayList<Int>()
        venezuela_list.add(7)
        venezuela_list.add(8)
        venezuela_list.add(9)
        venezuela_list.add(10)
        venezuela_list.add(11)
        pairWithCountry["104"] = venezuela_list
        pairWithCountry["43"] =
            java.util.ArrayList(listOf(8)) // Mongolia
        pairWithCountry["40"] =
            java.util.ArrayList(listOf(10)) // Philippines
        pairWithCountry["41"] =
            java.util.ArrayList(listOf(8)) // Singapore
        pairWithCountry["52"] = java.util.ArrayList(listOf(9)) // Vietnam
        return pairWithCountry
    }
}