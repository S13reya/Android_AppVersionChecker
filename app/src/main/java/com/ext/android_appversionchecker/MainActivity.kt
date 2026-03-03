package com.ext.android_appversionchecker


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ext.android_app_version_checker.*

class MainActivity : AppCompatActivity(), VersionCallback {

    lateinit var versionChecker: VersionChecker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        versionChecker = VersionChecker(
            this,
            "https://yourdomain.com/version.json", // Replace with your JSON URL
            this
        )

        versionChecker.checkVersion()
    }

    override fun onNoUpdate() {
        Toast.makeText(this, "App is up to date", Toast.LENGTH_SHORT).show()
    }

    override fun onSoftUpdate(message: String) {
        UpdateDialog.showSoftDialog(this, message) {
            versionChecker.openPlayStore()
        }
    }

    override fun onForceUpdate(message: String) {
        UpdateDialog.showForceDialog(this, message) {
            versionChecker.openPlayStore()
        }
    }

    override fun onError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}