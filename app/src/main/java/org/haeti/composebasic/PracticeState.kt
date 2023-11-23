package org.haeti.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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
    Column() {
        Text("Hello World")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "클릭")
        }
    }
}

class StateViewModel : ViewModel() {
    private val _value = mutableStateOf("Hello World")
    val value: State<String> = _value
}
