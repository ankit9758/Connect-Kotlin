package com.example.tvsconnectdemo.utils.anr

import okhttp3.internal.notifyAll

open class AnrDetectorCallback : Runnable {
    private var mCalled = false

    @Synchronized
    override fun run() {
        mCalled = true
        this.notifyAll()
    }

    @Synchronized
    fun isCalled(): Boolean {
        return mCalled
    }
}