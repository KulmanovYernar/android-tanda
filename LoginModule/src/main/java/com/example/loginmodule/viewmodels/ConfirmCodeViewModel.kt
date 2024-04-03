package com.example.loginmodule.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tandapp.utils.countDownTimer.CountDownTimerImpl

class ConfirmCodeViewModel() : ViewModel(),
    tandapp.utils.countDownTimer.CountDownTimer by CountDownTimerImpl() {

    fun resentCode(processInstanceId: String = "") {
        startTimer()
        viewModelScope.launch(Dispatchers.IO) {

        }
    }
}