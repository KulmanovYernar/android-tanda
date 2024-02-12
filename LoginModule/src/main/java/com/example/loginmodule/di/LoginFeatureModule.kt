package com.example.loginmodule.di

import com.example.loginmodule.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginFeatureModule = module {

    viewModel {
        LoginViewModel()
    }
}
