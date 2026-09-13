package com.shokhrukhyusupov.music.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.shokhrukhyusupov.music.presentation.home.HomeScreen
import com.shokhrukhyusupov.music.presentation.auth.login.LoginRoute

@Composable
fun AppNavHost(
    startDestination: AppRoute
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable<AppRoute.Login> {
            LoginRoute()
        }

        composable<AppRoute.Main.Home> {
            HomeScreen()
        }
    }
}
