package com.mgc.harrypotterapi.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    object LoginScreen : Screen(
        route = "login",
        arguments = emptyList()
    )

    object ForgotPasswordScreen : Screen(
        route = "forgotPassword",
        arguments = emptyList()
    )

    object CharacterListScreen : Screen(
        route = "characterList",
        arguments = emptyList()
    )

    object CharacterDetailScreen : Screen(
        route = "characterDetail",
        arguments = listOf(
            navArgument("characterId") {
                type = NavType.StringType
                nullable = false
            }
        )
    )

}
