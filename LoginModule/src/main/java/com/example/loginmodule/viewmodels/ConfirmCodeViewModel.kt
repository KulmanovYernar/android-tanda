package com.example.loginmodule.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.AuthRepository
import com.example.auth.model.ConfirmModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tandapp.utils.SharedPreferencesHelper
import tandapp.utils.countDownTimer.CountDownTimerImpl

class ConfirmCodeViewModel(
    private val authRepository: AuthRepository
) : ViewModel(),
    tandapp.utils.countDownTimer.CountDownTimer by CountDownTimerImpl() {

    private val _codeConfirmed: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val codeConfirmed: MutableStateFlow<Boolean> = _codeConfirmed

    val codeError = mutableStateOf(false)
    val email = mutableStateOf("")

    fun resentCode(processInstanceId: String = "") {
        startTimer()
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

    fun confirmAccount(otp: String) {
        viewModelScope.launch {
            authRepository.confirmAccount(
                ConfirmModel(
                    token = otp,
                    email = email.value
                )
            ).flowOn(Dispatchers.IO)
                .collect {
                    it.onSuccess {
                        Log.d("confirmAcc", "signUp: ")
                        _codeConfirmed.value = true
                        codeError.value = false
                        SharedPreferencesHelper.saveRegistered(true)
                        stopTimer()
                    }

                    it.onError {
                        Log.d("confirmAcc", "confirmAccount: asd")
                        codeError.value = true
                    }
                }
        }
    }

}