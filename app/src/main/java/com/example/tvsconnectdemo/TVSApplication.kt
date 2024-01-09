package com.example.tvsconnectdemo

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import com.example.tvsconnectdemo.utils.FileLoggingTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class TVSApplication:Application() {
    val TAG = "HereMapData"
    var isStopRideCalled = true
    var isFromServiceLocator = false
    var isOnRoute:kotlin.Boolean = false

    /*map my india starts*/
    private val altitude = 0.0
    val U_TURN_TIMESTAMP = (5 * 1000).toLong()
    val REROUTE_TIMESTAMP = (5 * 1000).toLong()
    var isSMSTriggered = false
    private val isCallPicked = false
    private val isCallOngoing = false
    private val currentActivity: Activity? = null

    // For Android 8.x BT problem alert
    var isOreoInfoAlertDisplayed = false


    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(FileLoggingTree())
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        var appClass: TVSApplication? = null
        /* save this */
        fun getInstance(): TVSApplication? {
            if (appClass == null) {
               appClass = TVSApplication()
            }
            return appClass
        }
    }
}