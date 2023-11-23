package org.haeti.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class PracticeState : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen(viewModel: StateViewModel = viewModel()) {
    val text1 = remember {
        mutableStateOf("Hello world")
    }

    var text2 by remember {
        mutableStateOf("Hello world")
    }

    val (text, setText) = remember {
        mutableStateOf("Hello world")
    }

    val text3: State<String> = viewModel.liveData.observeAsState("Hello world")

    Column() {
        Text("Hello World")
        Button(onClick = {
            viewModel.changeValue("변경")
        }) {
            Text(text = "클릭")
        }
    }
}

class StateViewModel : ViewModel() {
    private val _value = mutableStateOf("Hello World")
    val value: State<String> = _value

    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> = _liveData

    fun changeValue(value: String) {
        _value.value = value
    }
}
