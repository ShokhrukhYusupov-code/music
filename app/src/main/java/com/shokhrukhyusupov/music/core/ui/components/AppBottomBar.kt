package com.shokhrukhyusupov.music.core.ui.components

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.shokhrukhyusupov.music.R
import com.shokhrukhyusupov.music.core.navigation.AppRoute

sealed class BottomNavItem(
    val route: AppRoute.Main,
    val icon: ImageVector,
    @param:StringRes val titleRes: Int
) {
    data object Home : BottomNavItem(
        AppRoute.Main.Home, Icons.Default.Home, R.string.home
    )

    data object Search : BottomNavItem(
        AppRoute.Main.Search, Icons.Default.Search, R.string.search
    )

    data object Library :
        BottomNavItem(
            AppRoute.Main.Library, Icons.Default.LibraryMusic, R.string.library
        )

    data object Premium : BottomNavItem(
        AppRoute.Main.Premium, Icons.Default.Diamond, R.string.premium
    )
}

@Composable
fun AppBottomBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Library,
        BottomNavItem.Premium
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        items.forEach { item ->
            val selected = currentDestination?.hierarchy?.any {
                it.hasRoute(item.route::class)
            } == true

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(id = item.titleRes)
                    )
                },
                label = {
                    Text(text = stringResource(id = item.titleRes))
                }
            )
        }
    }
}