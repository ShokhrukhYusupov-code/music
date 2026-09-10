package com.shokhrukhyusupov.music.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoute {

    @Serializable
    data object Login : AppRoute

    @Serializable
    data object Home : AppRoute
}
