package org.haeti.composebasic

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _data = mutableStateOf("Hello")
    val data: State<String> = _data

    fun changeValue() {
        _data.value = "World"
    }
}
