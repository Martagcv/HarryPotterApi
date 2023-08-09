package com.mgc.harrypotterapi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost( // FragmentContainerView
        navController = navController,
        startDestination = Screen.LoginScreen.route,
    ) {
        addLoginScreen(navController)
        addForgotPasswordScreen()
        addCharacterListScreen(navController)
        addCharacterDetailScreen(navController)
    }
}