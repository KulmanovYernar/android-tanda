package com.example.tandaapp

import android.app.Application
import com.example.tandaapp.di.configureKoin

class TandaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        configureKoin(this)
    }
}