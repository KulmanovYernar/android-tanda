package com.example.loginmodule.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {
    val email: MutableState<String> = mutableStateOf("")
    val password: MutableState<String> = mutableStateOf("")
    val loginWithOtp: MutableState<Boolean> = mutableStateOf(true)

    fun onEmailChange(email: String) {
        this.email.value = email
    }

    fun onPasswordChange(password: String) {
        this.password.value = password
    }

    fun signUp() {
        viewModelScope.launch {
            authRepository.signUp(email.value, password = password.value).flowOn(Dispatchers.IO)
                .collect{
                    it.onSuccess {
                        Log.d("signUp", "signUp: ${it?.token}")
                    }
                }
        }
    }

}