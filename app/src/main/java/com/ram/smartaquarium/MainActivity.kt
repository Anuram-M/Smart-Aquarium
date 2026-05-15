package com.ram.smartaquarium

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.ram.smartaquarium.screens.ScreenComposable
import com.ram.smartaquarium.ui.theme.SmartAquariumTheme
import com.ram.smartaquarium.ui.theme.mOrange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartAquariumTheme {
                Scaffold(modifier = Modifier.fillMaxSize().background(mOrange)) { innerPadding ->
                    ScreenComposable(Modifier.padding(innerPadding))
                }
            }
        }
    }
}