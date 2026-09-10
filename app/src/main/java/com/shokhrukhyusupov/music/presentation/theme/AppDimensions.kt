package com.shokhrukhyusupov.music.presentation.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppDimensions(
    val screenPadding: Dp,

    val spacingExtraSmall: Dp,
    val spacingSmall: Dp,
    val spacingMedium: Dp,
    val spacingLarge: Dp,
    val spacingExtraLarge: Dp,

    val fieldHeight: Dp,
    val buttonHeight: Dp,

    val iconSmall: Dp,
    val iconMedium: Dp,
    val iconLarge: Dp,

    val avatarSmall: Dp,
    val avatarMedium: Dp,
    val avatarLarge: Dp
) {

    companion object {

        val Default = AppDimensions(
            screenPadding = 24.dp,

            spacingExtraSmall = 4.dp,
            spacingSmall = 8.dp,
            spacingMedium = 12.dp,
            spacingLarge = 24.dp,
            spacingExtraLarge = 32.dp,

            fieldHeight = 52.dp,
            buttonHeight = 52.dp,

            iconSmall = 16.dp,
            iconMedium = 24.dp,
            iconLarge = 32.dp,

            avatarSmall = 32.dp,
            avatarMedium = 48.dp,
            avatarLarge = 64.dp
        )
    }
}
