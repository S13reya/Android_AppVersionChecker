# **📱 Android App Version Checker (Force / Soft Update)**


---
A lightweight Android library to check app updates using a remote JSON file.
Supports Force Update and Soft Update without Firebase.

---

## ✨ **Features**

- ✅ Force Update

- ✅ Soft Update

- ✅ JSON-based version control

- ✅ Works with GitHub RAW hosting

- ✅ No Firebase required

- ✅ Easy integration



  ---

# **Preview**
---
<p align="center">
  <img src="https://github.com/S13reya/Android_StringExtensions/blob/stages/app/src/main/assets/demovideo.gif" height="320"/>




</p>




## ⚡ **Installation**

**Step 1:** Add JitPack repository to your root build.gradle:

```gradle
maven { url = uri("https://jitpack.io") }
```

**Step 2:** Add the dependency in your app `build.gradle` (example if hosted on JitPack):  

```gradle
dependencies {
	        implementation 'com.github.Excelsior-Technologies-Community:Android_StringExtensions:1.0.0'

}
```

## ⚡ **Permissions**

```
<uses-permission android:name="android.permission.INTERNET"/>

```





## ⚡ **MainActivity**
```
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
            "https://raw.githubusercontent.com/S13reya/Android_AppVersionChecker/refs/heads/stages/version.json",
            this
        )

        versionChecker.checkVersion()
    }

    override fun onNoUpdate() {
        Toast.makeText(this, "App is up to date", Toast.LENGTH_SHORT).show()
    }

    override fun onSoftUpdate(message: String) {
        UpdateDialog.showSoftDialog(this, message) {
            Toast.makeText(this, "Redirecting to update page...", Toast.LENGTH_SHORT).show()
//            versionChecker.openPlayStore()
        }
    }

    override fun onForceUpdate(message: String) {
        UpdateDialog.showForceDialog(this, message) {
            Toast.makeText(this, "Force Update Clicked!", Toast.LENGTH_SHORT).show()
//            versionChecker.openPlayStore()
        }
    }

    override fun onError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}

```


## **📄 License**

**MIT License**  
```
Copyright (c) 2025 Excelsior Technologies

Permission is hereby granted, free of charge, to any person obtaining a copy  
of this software and associated documentation files (the "Software"), to deal  
in the Software without restriction, including without limitation the rights  
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell  
copies of the Software, and to permit persons to whom the Software is  
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all  
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED **"AS IS"**, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,  
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
```



  
