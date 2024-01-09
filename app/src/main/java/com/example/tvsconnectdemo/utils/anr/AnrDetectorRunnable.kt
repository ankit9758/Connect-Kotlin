package com.example.tvsconnectdemo.utils.anr

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.tvsconnectdemo.utils.Utils
import okhttp3.internal.wait
import java.io.PrintWriter
import java.io.StringWriter

open class AnrDetectorRunnable(looper: Looper?): Runnable {
    /**
     * The [Handler] to access the UI threads message queue
     */
    private var mHandler: Handler? = null

    init {
        mHandler = Handler(Looper.getMainLooper())
    }

//     constructor(looper: Looper?) : this() {
//        mHandler = Handler(looper!!)
//    }

    /**
     * The stop flag
     */
    private var mStopped = false

    /**
     * Flag indicating the stop was performed
     */
    private var mStopCompleted = true

    //check
    var i = 0

    override fun run() {
        mStopCompleted = false

        // Loop until stop() was called or thread is interrupted

        // Loop until stop() was called or thread is interrupted
        while (!Thread.interrupted()) {
            try {
                // Log
                //Log.d(AnrDetector.class.getSimpleName(), "Check for ANR...");

                // Create new callback
                val callback = AnrDetectorCallback()

                // Perform test, Handler should run
                // the callback within 1s
                synchronized(callback) {
                    mHandler?.post(callback)
                    wait()
                    // Check if called
                    if (!callback.isCalled()) {
                        // Log
                        val e = AnrException(
                            mHandler!!.looper.thread
                        )
                        if (i == 1) {
                            //UI thread has not responded after 5 secs
                            //record ANR
                            e.printStackTrace()
                           // FirebaseCrashlytics.getInstance().recordException(e)
                            val sw = StringWriter()
                            e.printStackTrace(PrintWriter(sw))
                            val exceptionAsString = sw.toString()
                            Utils.saveAppCrashLogs(exceptionAsString)
//                            if (BuildConfig.isCustomerBuild) {
//                                TVSLogHelper.logInfo(
//                                    javaClass,
//                                    "******************************************************************"
//                                )
//                                TVSLogHelper.logInfo(
//                                    javaClass,
//                                    mHandler!!.looper.thread.name
//                                )
                               // TVSLogHelper.logInfo(javaClass, exceptionAsString)
//                                TVSLogHelper.logInfo(
//                                    javaClass,
//                                    "******************************************************************"
//                                )
                        //    }
                            //e.logProcessMap();
                            // Wait until the thread responds again
                            Log.d(
                                AnrDetector::class.java.simpleName,
                                "UI Thread didn't respond...wait till it responds"
                            )
                            i = 0
                            callback.wait()
                        } else {
                            //wait 5secs and check again
                            Log.d(
                                AnrDetector::class.java.simpleName,
                                "UI Thread didn't respond...checking again in 5s"
                            )
                            //callback.wait(5000);
                            i++
                        }
                    } else {
                        //Log.d(AnrDetector.class.getSimpleName(), "UI Thread responded within 1s");
                    }
                }

                // Check if stopped
                this.checkStopped()

                // Sleep for next test
                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
                break
            }
        }

        // Set stop completed flag

        // Set stop completed flag
        mStopCompleted = true

        // Log

        // Log
        Log.d(AnrDetector::class.java.simpleName, "ANR supervision stopped")
    }

    @Synchronized
    @Throws(InterruptedException::class)
     open fun checkStopped() {
        if (mStopped) {
            // Wait 1000ms
            Thread.sleep(5000)

            // Break if still stopped
            if (mStopped) {
                throw InterruptedException()
            }
        }
    }

    /**
     * Stops the check
     */
    @Synchronized
    open fun stop() {
        Log.d(AnrDetector::class.java.simpleName, "Stopping...")
        mStopped = true
    }

    /**
     * Stops the check
     */
    @Synchronized
    open fun unstop() {
        Log.d(AnrDetector::class.java.simpleName, "Revert stopping...")
        mStopped = false
    }

    /**
     * Returns whether the stop is completed
     *
     * @return true if stop is completed, false if not
     */
    @Synchronized
    open fun isStopped(): Boolean {
        return mStopCompleted
    }

    @Synchronized
    open fun setmStopped(value: Boolean) {
        mStopped = value
    }
}