package com.example.loginmodule.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import tandapp.utils.countDownTimer.CountDownTimerImpl

class ConfirmCodeViewModel(
    private val authRepository: AuthRepository
) : ViewModel(),
    tandapp.utils.countDownTimer.CountDownTimer by CountDownTimerImpl() {

    private val _codeConfirmed: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val codeConfirmed: MutableStateFlow<Boolean> = _codeConfirmed

    fun resentCode(processInstanceId: String = "") {
        startTimer()
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

    fun signUpSubmit(otp: String) {
        viewModelScope.launch {
            authRepository.signUpConfirmation(
                token = otp
            ).flowOn(Dispatchers.IO)
                .collect{
                    it.onSuccess {
                        Log.d("signUp", "signUp: ")
                        _codeConfirmed.value = true
                        stopTimer()
                    }
                }
        }
    }

}