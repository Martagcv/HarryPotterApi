package com.mgc.harrypotterapi.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.mgc.harrypotterapi.presentation.detail.CharacterDetailScreen
import com.mgc.harrypotterapi.presentation.forgot.ForgotPasswordScreen
import com.mgc.harrypotterapi.presentation.list.CharacterListScreen
import com.mgc.harrypotterapi.presentation.login.LoginScreen

fun NavGraphBuilder.addLoginScreen(navController: NavController) {
    composable(Screen.LoginScreen.route) {
        LoginScreen(
            onForgotClicked = {
                navController.navigate(Screen.ForgotPasswordScreen.route)
            },
            onLoginSuccess = {
                navController.navigate(Screen.CharacterListScreen.route)
            }
        )
    }
}

fun NavGraphBuilder.addForgotPasswordScreen() {
    composable(Screen.ForgotPasswordScreen.route) {
        ForgotPasswordScreen()
    }
}

fun NavGraphBuilder.addCharacterListScreen(navController: NavHostController) {
    composable(Screen.CharacterListScreen.route) {
        CharacterListScreen{ characterId ->
            navController.navigate("${Screen.CharacterDetailScreen.route}/$characterId")
        }
    }
}

 fun NavGraphBuilder.addCharacterDetailScreen(navController: NavHostController) {
    composable(
        route = Screen.CharacterDetailScreen.route + "/{characterId}",
        arguments = Screen.CharacterDetailScreen.arguments
    ) { navBackStackEntry ->
       val id = navBackStackEntry.arguments?.getString("characterId") ?: ""
       CharacterDetailScreen(id = id) {
            navController.popBackStack()
        }
    }
}