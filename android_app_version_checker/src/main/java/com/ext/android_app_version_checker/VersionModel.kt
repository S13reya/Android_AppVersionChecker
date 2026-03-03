package com.ext.android_app_version_checker


data class VersionModel(
    val latest_version: Int,
    val update_type: String,
    val update_message: String
)