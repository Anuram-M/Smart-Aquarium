package com.ram.smartaquarium.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ram.smartaquarium.util.MqttHelper

@Composable
fun ScreenComposable(modifier: Modifier) {
    val context = LocalContext.current.applicationContext
    val mqttHelper = MqttHelper(context)
    val navController = rememberNavController()
    NavHost(
        startDestination = "loading",
        navController = navController,) {
        composable("loading") {LoadingComposable(navController)}
        composable("home") { HomeScreenComposable() }
    }
}