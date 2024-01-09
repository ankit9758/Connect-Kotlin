package com.example.tvsconnectdemo.utils

import android.app.Activity
import android.content.DialogInterface
import android.os.Environment
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.tvsconnectdemo.BuildConfig
import com.example.tvsconnectdemo.R
import com.example.tvsconnectdemo.TVSApplication
import com.example.tvsconnectdemo.utils.FileStorageConstants.FOLDER_ASSETS
import com.example.tvsconnectdemo.utils.FileStorageConstants.FOLDER_LOGS
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.util.*

object Utils {
    fun isDeviceNotRooted(context: Activity): Boolean {
        if (!RootDetectionUtil.isDeviceRooted()) {
            return true
        } else {
            val alertBuilder = AlertDialog.Builder(context).setTitle("Error!")
                .setMessage(context.getString(R.string.alert_rooted_device)).setNeutralButton(
                    context.getString(R.string.ok)
                ) { dialog: DialogInterface?, which: Int -> context.finish() }.setCancelable(false)
            val dialog = alertBuilder.create()
            dialog.setOnShowListener {
                val bPos = dialog.getButton(DialogInterface.BUTTON_NEUTRAL)
                if (bPos != null) {
                    bPos.setTextColor(ContextCompat.getColor(context, R.color.colorAccent))
                    bPos.invalidate()
                }
            }
            if (!dialog.isShowing) dialog.show()
        }
        return false
    }
    fun saveAppCrashLogs(log: String) {
        Log.e("APP_CRASH_LOG", log)
        if (BuildConfig.DEBUG) {
            var bw: BufferedWriter? = null
            try {
                val filePath: String =getLogsPath() + "tvs-app-crash-log.txt"
                bw = BufferedWriter(FileWriter(filePath, true))
                bw.write(Calendar.getInstance().time.toString() + ":::>\t\t" + log)
                bw.newLine()
                bw.flush()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                if (bw != null) {
                    try {
                        bw.close()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }

    /**
     * This function is returning the path of logs folder
     *
     * @return
     */
    fun getLogsPath(): String? {
        return (getStoragePath().toString() + FOLDER_LOGS).toString() + File.separator
    }

    /**
     * This function is used to point external storage for app (Scope Storage)
     *
     * @return
     */
    fun getStoragePath(): File? = if (isExternalStorageWritable()) {
            TVSApplication.getInstance()?.getExternalFilesDir(null)
    } else TVSApplication.getInstance()?.filesDir

    // Checks if a volume containing external storage is available
    // for read and write.
    private fun isExternalStorageWritable(): Boolean {
        return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
    }
    fun deleteImage() {
        var file: File = File(getAssetsPath() + "my_profile.jpg")
        if (file.exists()) {
            file.delete()
        }
        file = File(getAssetsPath() + "pro_pic.jpg")
        if (file.exists()) {
            file.delete()
        }
    }

    /**
     * This function is returning the path of asset folder
     *
     * @return
     */
    fun getAssetsPath(): String {
        return (getStoragePath().toString().plus(FOLDER_ASSETS) + File.separator)
    }
}