package com.example.tvsconnectdemo.utils.anr

import android.os.Looper
import android.util.Log
import java.util.concurrent.Executors

class AnrDetector {
    private val mExecutor = Executors.newSingleThreadExecutor()

    private var anrDetectorRunnable: AnrDetectorRunnable? = null

     constructor(looper: Looper?) {
        anrDetectorRunnable = AnrDetectorRunnable(looper)
    }

    /**
     * Starts the detection
     */
    @Synchronized
    fun start() {
        synchronized(anrDetectorRunnable!!) {
            if (anrDetectorRunnable?.isStopped()==true) {
                anrDetectorRunnable?.setmStopped(false)
                mExecutor.execute(anrDetectorRunnable)
                Log.d(javaClass.simpleName, "execute anrDetectorRunnable")
            } else {
                anrDetectorRunnable?.unstop()
                Log.d(javaClass.simpleName, "unstopp anrDetectorRunnable")
            }
        }
    }

    /**
     * Stops the detection. The stop is delayed, so if
     * start() is called right after stop(),
     * both methods will have no effect. There will be at least one
     * more ANR check before the supervision is stopped.
     */
    @Synchronized
    fun stop() {
        anrDetectorRunnable?.stop()
        Log.d(javaClass.simpleName, "stopp anrDetectorRunnable")
    }
}