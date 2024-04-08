package com.example.tandaapp.di

import android.content.Context
import com.example.auth.di.authRepositoryModule
import com.example.loginmodule.di.loginFeatureModule
import domain.retrofit.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import tandapp.backetmodule.di.backetFeatureModule
import tandapp.catalogmodule.di.catalogModule
import tandapp.homemodule.di.homeFeatureModule
import tandapp.profilemodule.di.profileFeatureModule

internal fun configureKoin(context: Context) {
    startKoin {
        androidContext(context)

        modules(
            networkModule,
            loginFeatureModule,
            homeFeatureModule,
            backetFeatureModule,
            profileFeatureModule,
            authRepositoryModule,
            catalogModule
        )
    }
}