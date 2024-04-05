package com.example.auth.di

import com.example.auth.AuthRepository
import com.example.auth.AuthRepositoryImpl
import com.example.auth.AuthService
import domain.retrofit.di.networkModule
import org.koin.dsl.module
import retrofit2.Retrofit

private val authServiceModule = module {
    includes(networkModule)
    single { get<Retrofit>().create(AuthService::class.java) }
}

val authRepositoryModule = module {
    includes(authServiceModule)
    single<AuthRepository> { AuthRepositoryImpl(get()) }
}