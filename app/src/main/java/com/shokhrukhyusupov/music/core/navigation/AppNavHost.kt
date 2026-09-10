package com.shokhrukhyusupov.music.core.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.shokhrukhyusupov.music.presentation.home.HomeScreen
import com.shokhrukhyusupov.music.presentation.login.LoginScreen
import com.shokhrukhyusupov.music.presentation.login.LoginViewModel
import com.shokhrukhyusupov.music.presentation.login.LoginViewModelFactory

@Composable
fun AppNavHost(
    navController: NavHostController,
    loginViewModelFactory: LoginViewModelFactory
) {
    NavHost(
        navController = navController,
        startDestination = AppRoute.Login
    ) {

        composable<AppRoute.Login> {

            val viewModel: LoginViewModel = viewModel(
                factory = loginViewModelFactory
            )

            LoginScreen(
                viewModel = viewModel,
                onLoginSuccess = {
                    navController.navigate(AppRoute.Home) {
                        popUpTo(AppRoute.Login) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable<AppRoute.Home> {
            HomeScreen()
        }
    }
}
