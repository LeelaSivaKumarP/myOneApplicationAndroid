package com.myone.application

import android.app.Application
import android.content.Context

class MyOneApp: Application() {

    companion object {
        @JvmStatic
        var appContext: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        appContext = getApplicationContext()
    }
}