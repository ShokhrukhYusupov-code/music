package com.shokhrukhyusupov.music.presentation.theme

import androidx.compose.ui.graphics.Color

data class AppColors(
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,

    val secondary: Color,
    val onSecondary: Color,
    val secondaryContainer: Color,
    val onSecondaryContainer: Color,

    val background: Color,
    val onBackground: Color,

    val surface: Color,
    val onSurface: Color,
    val surfaceVariant: Color,
    val onSurfaceVariant: Color,

    val outline: Color,
    val outlineVariant: Color,

    val error: Color,
    val onError: Color,
    val errorContainer: Color,
    val onErrorContainer: Color,

    val favorite: Color,
    val playing: Color,

    val playerBackground: Color,
    val playerSurface: Color,
    val progress: Color,
    val progressTrack: Color,

    val success: Color,
    val warning: Color,
    val info: Color
) {

    companion object {

        val Light = AppColors(
            primary = Color(0xFF10684E),
            onPrimary = Color(0xFFFFFFFF),
            primaryContainer = Color(0xFFA6F3D4),
            onPrimaryContainer = Color(0xFF002117),

            secondary = Color(0xFF4F635A),
            onSecondary = Color(0xFFFFFFFF),
            secondaryContainer = Color(0xFFD2E8DE),
            onSecondaryContainer = Color(0xFF0B1F18),

            background = Color(0xFFF7FBF8),
            onBackground = Color(0xFF171D1A),

            surface = Color(0xFFF7FBF8),
            onSurface = Color(0xFF171D1A),
            surfaceVariant = Color(0xFFDCE5E0),
            onSurfaceVariant = Color(0xFF5A635E),

            outline = Color(0xFF707974),
            outlineVariant = Color(0xFFC0C9C4),

            error = Color(0xFFBA1A1A),
            onError = Color(0xFFFFFFFF),
            errorContainer = Color(0xFFFFDAD6),
            onErrorContainer = Color(0xFF410002),

            favorite = Color(0xFFE53935),
            playing = Color(0xFF189C74),

            playerBackground = Color(0xFF10201A),
            playerSurface = Color(0xFFEFF8F3),
            progress = Color(0xFF189C74),
            progressTrack = Color(0xFFD2E8DE),

            success = Color(0xFF189C74),
            warning = Color(0xFFE6A700),
            info = Color(0xFF0077C6)
        )

        val Dark = AppColors(
            primary = Color(0xFF62D9AC),
            onPrimary = Color(0xFF003827),
            primaryContainer = Color(0xFF00513B),
            onPrimaryContainer = Color(0xFFA6F3D4),

            secondary = Color(0xFFB6CCC2),
            onSecondary = Color(0xFF21352D),
            secondaryContainer = Color(0xFF374A42),
            onSecondaryContainer = Color(0xFFD2E8DE),

            background = Color(0xFF0F1512),
            onBackground = Color(0xFFE0E5E1),

            surface = Color(0xFF0F1512),
            onSurface = Color(0xFFE0E5E1),
            surfaceVariant = Color(0xFF242E29),
            onSurfaceVariant = Color(0xFF9FA8A3),

            outline = Color(0xFF8A938E),
            outlineVariant = Color(0xFF404944),

            error = Color(0xFFFFB4AB),
            onError = Color(0xFF690005),
            errorContainer = Color(0xFF93000A),
            onErrorContainer = Color(0xFFFFDAD6),

            favorite = Color(0xFFFF6B6B),
            playing = Color(0xFF62D9AC),

            playerBackground = Color(0xFF08110D),
            playerSurface = Color(0xFF17221D),
            progress = Color(0xFF62D9AC),
            progressTrack = Color(0xFF374A42),

            success = Color(0xFF62D9AC),
            warning = Color(0xFFFFC107),
            info = Color(0xFF29B6F6)
        )
    }
}