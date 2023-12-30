package org.haeti.stopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.Timer
import kotlin.concurrent.timer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}

class MainViewModel : ViewModel() {

    private var time = 0
    private var timerTask: Timer? = null

    private val _isRunning = mutableStateOf(false)
    val isRunning: State<Boolean> = _isRunning

    private val _sec = mutableStateOf(0)
    val sec: State<Int> = _sec

    private val _milliSec = mutableStateOf(0)
    val milliSec: State<Int> = _milliSec

    private val _lapTimes = mutableStateOf(mutableListOf<String>())
    val lapTimes: State<List<String>> = _lapTimes

    private var lap = 1

    fun start() {
        _isRunning.value = true

        timerTask = timer(period = 10) {
            time++
            _sec.value = time / 100
            _milliSec.value = time % 100
        }
    }

    fun pause() {
        _isRunning.value = false
        timerTask?.cancel()
    }

    fun reset() {
        timerTask?.cancel()

        time = 0
        _isRunning.value = false
        _sec.value = 0
        _milliSec.value = 0

        _lapTimes.value.clear()
        lap = 1
    }

    fun recordLapTime() {
        _lapTimes.value.add(0, "$lap LAP: ${sec.value}.${milliSec.value}")
        lap++
    }
}
