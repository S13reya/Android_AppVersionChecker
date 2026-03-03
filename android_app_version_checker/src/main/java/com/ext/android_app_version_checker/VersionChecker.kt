package com.ext.android_app_version_checker


import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class VersionChecker(
    private val activity: Activity,
    private val jsonUrl: String,
    private val callback: VersionCallback
) {

    fun checkVersion() {

        val client = OkHttpClient()
        val request = Request.Builder().url(jsonUrl).build()

        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                activity.runOnUiThread {
                    callback.onError("Network Error")
                }
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string() ?: return

                try {
                    val json = JSONObject(body)
                    val latestVersion = json.getInt("latest_version")
                    val updateType = json.getString("update_type")
                    val message = json.getString("update_message")

                    val currentVersion =
                        activity.packageManager
                            .getPackageInfo(activity.packageName, 0)
                            .versionCode

                    activity.runOnUiThread {

                        if (latestVersion > currentVersion) {

                            if (updateType.equals("force", true)) {
                                callback.onForceUpdate(message)
                            } else {
                                callback.onSoftUpdate(message)
                            }

                        } else {
                            callback.onNoUpdate()
                        }
                    }

                } catch (e: Exception) {
                    activity.runOnUiThread {
                        callback.onError("Parsing Error")
                    }
                }
            }
        })
    }

    fun openPlayStore() {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://play.google.com/store/apps/details?id=${activity.packageName}")
        }
        activity.startActivity(intent)
    }
}