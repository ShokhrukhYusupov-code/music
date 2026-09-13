package com.shokhrukhyusupov.music.core.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val LightColorScheme = lightColorScheme(
    background = Color(0xFFF5F5F5),

    primary = Color(0xFF179c74),
    onPrimary = Color.White,

    secondary = Color(0xFF4F8F7A),
    onSecondary = Color.White,

    surface = Color.White,
    surfaceContainer = Color(0xFFEFEFEF),
    secondaryContainer = Color(0xFFD7F1E8),
    onSecondaryContainer = Color(0xFF0B3D2F),
    onSurfaceVariant = Color(0xFF5F6361),

    error = Color(0xFFBA1A1A),
    onError = Color.White,
)

val DarkColorScheme = darkColorScheme(
    background = Color(0xFF121212),

    primary = Color(0xFF179c74),
    onPrimary = Color.Black,

    secondary = Color(0xFF4F8F7A),
    onSecondary = Color.White,

    surface = Color(0xFF1E1E1E),
    surfaceContainer = Color(0xFF242424),
    secondaryContainer = Color(0xFF164D3D),
    onSecondaryContainer = Color(0xFFB9EEDB),
    onSurfaceVariant = Color(0xFF5F6361),

    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
)
