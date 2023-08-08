package com.example.loginscreen2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.loginscreen2.ui.theme.ComposeLoginScreenInitTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLoginScreenInitTheme {
                LoginScreen()
            }

        }
    }
}

