package com.ext.android_app_version_checker


import android.app.AlertDialog
import android.app.Activity

object UpdateDialog {

    fun showForceDialog(activity: Activity, message: String, onUpdate: () -> Unit) {
        AlertDialog.Builder(activity)
            .setTitle("Update Required")
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton("Update") { _, _ -> onUpdate() }
            .show()
    }

    fun showSoftDialog(activity: Activity, message: String, onUpdate: () -> Unit) {
        AlertDialog.Builder(activity)
            .setTitle("Update Available")
            .setMessage(message)
            .setCancelable(true)
            .setPositiveButton("Update") { _, _ -> onUpdate() }
            .setNegativeButton("Later", null)
            .show()
    }
}