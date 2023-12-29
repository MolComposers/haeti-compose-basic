package org.haeti.bmicalculator

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class BmiViewModel : ViewModel() {
    private val _bmi = mutableStateOf(0.0)
    val bmi: State<Double> = _bmi

    fun calculateBmi(
        height: Double,
        weight: Double,
    ) {
        _bmi.value = weight / (height / 100).pow(2.0)
    }
}
