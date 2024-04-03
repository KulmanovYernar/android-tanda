package tandapp.utils.countDownTimer

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CountDownTimerImpl(): CountDownTimer {
    private val countDownIntervalMillis = 1000L
    override val defaultTimerDurationMillis: Long
        get() = 60000L

    private val _isTimerRunning = MutableStateFlow(false)
    override val isTimerRunning: StateFlow<Boolean>
        get() = _isTimerRunning

    private val _currentTimerValue = MutableStateFlow(formatTimer(defaultTimerDurationMillis))
    override val timerCurrentValue: StateFlow<String>
        get() = _currentTimerValue

    private lateinit var timer: android.os.CountDownTimer

    // CountDownTimer can only run on UI thread
    private val scope = CoroutineScope(Dispatchers.Main)

    override fun startTimer(timerDurationMillis: Long) {
        if (!_isTimerRunning.value) {
            scope.launch {
                timer = object : android.os.CountDownTimer(
                    timerDurationMillis, countDownIntervalMillis
                ) {
                    override fun onTick(millisUntilFinished: Long) {
                        val time = formatTimer(millisUntilFinished)
                        _currentTimerValue.value = time
                        Log.d(TAG, "currentTimerValue: ${_currentTimerValue.value}")
                    }

                    override fun onFinish() {
                        _isTimerRunning.value = false
                    }
                }
                timer.start()
            }
            _isTimerRunning.value = true
        } else {
            scope.launch { timer.cancel() }
            _isTimerRunning.value = false
//            throw IllegalStateException("Cannot run more than 1 timer at once.")
        }
    }

    override fun stopTimer() {
        if (_isTimerRunning.value) {
            scope.launch { timer.cancel() }
            _isTimerRunning.value = false
        }
    }

    private fun Long.getMinutes() = this / countDownIntervalMillis / 60L
    private fun Long.getSeconds() = (this / countDownIntervalMillis) % 60L

    private fun formatTimer(millisUntilFinished: Long): String {
        val seconds = millisUntilFinished.getSeconds()
        return if (seconds > 9) {
            "${millisUntilFinished.getMinutes()}:${seconds}"
        } else {
            "${millisUntilFinished.getMinutes()}:0${seconds}"
        }
    }

    companion object {
        private val TAG = CountDownTimerImpl::class.qualifiedName
    }
}