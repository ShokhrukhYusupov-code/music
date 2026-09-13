package com.shokhrukhyusupov.music.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoute {
    @Serializable data object Login : AppRoute

    @Serializable
    sealed interface Main : AppRoute {
        @Serializable data object Home : Main
        @Serializable data object Search : Main
        @Serializable data object Library : Main
        @Serializable data object Premium : Main
    }
}