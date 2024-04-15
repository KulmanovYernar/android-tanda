package com.example.tandaapp

import android.app.Application
import android.content.Context
import com.example.tandaapp.di.configureKoin
import tandapp.utils.SharedPreferencesHelper
private const val TANDA_APP_PREF = "freedom_app_pref"

class TandaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPreferencesHelper.init(
            getSharedPreferences(TANDA_APP_PREF, Context.MODE_PRIVATE)
        )
        configureKoin(this)
    }
}