package com.dokarun.zigzag

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dokarun.zigzag.ui.theme.ZIGZAGTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            ZIGZAGTheme {
                val appState = rememberZigzagAppState()
                ZigzagNavHost(appState = appState)
            }
        }
    }
}
