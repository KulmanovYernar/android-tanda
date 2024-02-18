package com.example.loginmodule.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PasswordRecoveryViewModel():ViewModel() {
    val email: MutableState<String> = mutableStateOf("")

    fun onEmailChange(email: String) {
        this.email.value = email
    }
}