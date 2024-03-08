package com.example.tandaapp.di

import android.content.Context
import com.example.loginmodule.di.loginFeatureModule
import domain.retrofit.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import tandapp.backetmodule.di.backetFeatureModule
import tandapp.profilemodule.di.profileFeatureModule

internal fun configureKoin(context: Context) {
    startKoin {
        androidContext(context)

        modules(
            loginFeatureModule,
            networkModule,
            backetFeatureModule,
            profileFeatureModule
        )
    }
}