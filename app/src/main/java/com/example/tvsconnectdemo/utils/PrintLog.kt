package com.example.tvsconnectdemo.utils

import com.example.tvsconnectdemo.BuildConfig
import timber.log.Timber

object PrintLog {

    private val isDebug: Boolean = BuildConfig.DEBUG

    /**
     * Is debug boolean.
     *
     * @return the boolean
     */
    fun isDebug(): Boolean {
        return isDebug
    }

    /**
     * E.
     *
     * @param tag     the tag
     * @param message the message
     */
    fun e(tag: String, message: String?) {
        if (isDebug) Timber.tag(tag).e(message)
    }

    /**
     * E.
     *
     * @param tag     the tag
     * @param message the message
     */
    fun e(tag: String, message: String?, throwable: Throwable?) {
        if (isDebug) Timber.tag(tag).e(throwable,message)
    }

    /**
     * I.
     *
     * @param tag     the tag
     * @param message the message
     */
    fun i(tag: String, message: String?) {
        if (isDebug) Timber.tag(tag).i(message)
    }

    /**
     * V.
     *
     * @param tag     the tag
     * @param message the message
     */
    fun v(tag: String, message: String?) {
        if (isDebug) Timber.tag(tag).v(message)
    }

    /**
     * D.
     *
     * @param tag     the tag
     * @param message the message
     */
    fun d(tag: String, message: String?) {
        if (isDebug) Timber.tag(tag).d(message)
    }
}