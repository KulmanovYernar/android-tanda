package tandapp.utils.countDownTimer

import kotlinx.coroutines.flow.StateFlow

interface CountDownTimer {
    val defaultTimerDurationMillis: Long

    val isTimerRunning: StateFlow<Boolean>
    val timerCurrentValue: StateFlow<String>

    fun startTimer(timerDurationMillis: Long = defaultTimerDurationMillis)
    fun stopTimer()
}