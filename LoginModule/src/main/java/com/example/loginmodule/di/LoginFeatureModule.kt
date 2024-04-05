package com.example.loginmodule.di

import com.example.loginmodule.viewmodels.ConfirmCodeViewModel
import com.example.loginmodule.viewmodels.LoginViewModel
import com.example.loginmodule.viewmodels.PasswordRecoveryViewModel
import com.example.loginmodule.viewmodels.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginFeatureModule = module {

    viewModel {
        LoginViewModel(get())
    }
    viewModel {
        RegistrationViewModel()
    }
    viewModel {
        PasswordRecoveryViewModel()
    }
    viewModel {
        ConfirmCodeViewModel()
    }
}
