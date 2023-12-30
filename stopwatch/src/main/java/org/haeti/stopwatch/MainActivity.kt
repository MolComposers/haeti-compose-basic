package org.haeti.stopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.Timer

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

    private val lap = 1

    fun start() {
    }

    fun pause() {
    }

    fun reset() {
    }

    fun recordLapTime() {
    }
}
