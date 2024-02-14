package com.example.loginmodule.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RegistrationViewModel():ViewModel() {

    val email: MutableState<String> = mutableStateOf("")
    val password: MutableState<String> = mutableStateOf("")
    val repeatPassword: MutableState<String> = mutableStateOf("")

    fun onEmailChange(email: String) {
        this.email.value = email
    }

    fun onPasswordChange(password: String) {
        this.password.value = password
    }
    fun onRepeatPasswordChange(repeatPassword: String) {
        this.repeatPassword.value = repeatPassword
    }

    fun checkPasswordFields(){

    }

}