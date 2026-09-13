package com.shokhrukhyusupov.music.presentation.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shokhrukhyusupov.music.core.navigation.AppRoute
import com.shokhrukhyusupov.music.presentation.library.LibraryScreen
import com.shokhrukhyusupov.music.presentation.premium.PremiumScreen
import com.shokhrukhyusupov.music.presentation.search.SearchScreen
import com.shokhrukhyusupov.music.core.ui.components.AppBottomBar

@Composable
fun HomeScreen() {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            AppBottomBar(navController = bottomNavController)
        }
    ) { innerPadding ->
        NavHost(
            navController = bottomNavController,
            startDestination = AppRoute.Main.Home,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<AppRoute.Main.Home> {
                HomeContent()
            }
            composable<AppRoute.Main.Search> {
                SearchScreen()
            }
            composable<AppRoute.Main.Library> {
                LibraryScreen()
            }
            composable<AppRoute.Main.Premium> {
                PremiumScreen()
            }
        }
    }
}