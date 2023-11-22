package org.haeti.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class Navigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "first") {
                composable("first") {
                    FirstScreen()
                }
                composable("second") {
                    SecondScreen()
                }
                composable("third") {
                    ThirdScreen()
                }
            }
        }
    }
}

@Composable
fun FirstScreen() {
}

@Composable
fun SecondScreen() {
}

@Composable
fun ThirdScreen() {
}
