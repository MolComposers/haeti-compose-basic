package org.haeti.composebasic

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val data = mutableStateOf("Hello")
}
