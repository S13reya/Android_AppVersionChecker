package com.ext.android_app_version_checker


interface VersionCallback {
    fun onNoUpdate()
    fun onSoftUpdate(message: String)
    fun onForceUpdate(message: String)
    fun onError(error: String)
}