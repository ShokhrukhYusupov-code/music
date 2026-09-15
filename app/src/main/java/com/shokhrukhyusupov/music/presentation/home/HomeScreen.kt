package com.shokhrukhyusupov.music.presentation.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.shokhrukhyusupov.music.core.navigation.AppRoute
import com.shokhrukhyusupov.music.presentation.library.LibraryScreen
import com.shokhrukhyusupov.music.presentation.premium.PremiumScreen
import com.shokhrukhyusupov.music.presentation.search.SearchScreen
import com.shokhrukhyusupov.music.core.ui.components.AppBottomBar
import com.shokhrukhyusupov.music.presentation.settings.SettingsRoute
import kotlinx.coroutines.launch

@Composable
fun HomeScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val bottomNavController = rememberNavController()
    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "Музыкальное приложение",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
                HorizontalDivider()
                Spacer(Modifier.height(8.dp))

                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text("Главная") },
                    selected = navBackStackEntry?.destination?.hasRoute<AppRoute.Main.Home>() == true,
                    onClick = {
                        bottomNavController.navigate(AppRoute.Main.Home) {
                            // Безопасный popUpTo через класс объекта AppRoute, а не через graph.findStartDestination()
                            popUpTo(AppRoute.Main.Home) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                        scope.launch { drawerState.close() }
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )

                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = null) },
                    label = { Text("Избранное") },
                    selected = navBackStackEntry?.destination?.hasRoute<AppRoute.Main.Library>() == true,
                    onClick = {
                        bottomNavController.navigate(AppRoute.Main.Library) {
                            popUpTo(AppRoute.Main.Home) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                        scope.launch { drawerState.close() }
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )

                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Settings, contentDescription = null) },
                    label = { Text("Настройки") },
                    selected = navBackStackEntry?.destination?.hasRoute<AppRoute.Main.Settings>() == true,
                    onClick = {
                        bottomNavController.navigate(AppRoute.Main.Settings) {
                            popUpTo(AppRoute.Main.Home) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                        scope.launch { drawerState.close() }
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
            }
        }
    ) {
        Scaffold(
            bottomBar = {
                AppBottomBar(navController = bottomNavController)
            }
        ) { innerPadding ->
            NavHost(
                navController = bottomNavController,
                startDestination = AppRoute.Main.Home,
                modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())
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
                composable<AppRoute.Main.Settings> {
                    SettingsRoute()
                }
            }
        }
    }
}