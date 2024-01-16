package com.example.tvsconnectdemo.utils

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog


object DialogUtils {
    /**
     * Creates comman confirmation dialog with Yes-No Button. By default the buttons just dismiss the
     * dialog.
     *
     * @param ctx         the ctx
     * @param message     Message to be shown in the dialog.
     * @param yesListener Yes click handler
     * @param noListener  the no listener
     * @param yesLabel    Label for yes button
     * @param noLabel     Label for no button
     */
    fun showConfirmDialog(
        ctx: Context?,
        message: String?,
        yesListener: DialogInterface.OnClickListener?,
        noListener: DialogInterface.OnClickListener?,
        yesLabel: String?,
        noLabel: String?
    ) {
        var yesListener = yesListener
        var noListener = noListener
        val builder = AlertDialog.Builder(ctx!!)
        if (yesListener == null) {
            yesListener =
                DialogInterface.OnClickListener { dialog: DialogInterface, which: Int -> dialog.dismiss() }
        }
        if (noListener == null) {
            noListener =
                DialogInterface.OnClickListener { dialog: DialogInterface, which: Int -> dialog.dismiss() }
        }
        builder.setMessage(message).setPositiveButton(yesLabel, yesListener)
            .setNegativeButton(noLabel, noListener).setCancelable(false).show()
    }
}