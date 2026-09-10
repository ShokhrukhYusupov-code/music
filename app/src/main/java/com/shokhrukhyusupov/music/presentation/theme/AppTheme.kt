package com.shokhrukhyusupov.music.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = AppColors.Light.primary,
    onPrimary = AppColors.Light.onPrimary,
    primaryContainer = AppColors.Light.primaryContainer,
    onPrimaryContainer = AppColors.Light.onPrimaryContainer,

    secondary = AppColors.Light.secondary,
    onSecondary = AppColors.Light.onSecondary,
    secondaryContainer = AppColors.Light.secondaryContainer,
    onSecondaryContainer = AppColors.Light.onSecondaryContainer,

    background = AppColors.Light.background,
    onBackground = AppColors.Light.onBackground,

    surface = AppColors.Light.surface,
    onSurface = AppColors.Light.onSurface,
    surfaceVariant = AppColors.Light.surfaceVariant,
    onSurfaceVariant = AppColors.Light.onSurfaceVariant,

    outline = AppColors.Light.outline,
    outlineVariant = AppColors.Light.outlineVariant,

    error = AppColors.Light.error,
    onError = AppColors.Light.onError,
    errorContainer = AppColors.Light.errorContainer,
    onErrorContainer = AppColors.Light.onErrorContainer
)

private val DarkColorScheme = darkColorScheme(
    primary = AppColors.Dark.primary,
    onPrimary = AppColors.Dark.onPrimary,
    primaryContainer = AppColors.Dark.primaryContainer,
    onPrimaryContainer = AppColors.Dark.onPrimaryContainer,

    secondary = AppColors.Dark.secondary,
    onSecondary = AppColors.Dark.onSecondary,
    secondaryContainer = AppColors.Dark.secondaryContainer,
    onSecondaryContainer = AppColors.Dark.onSecondaryContainer,

    background = AppColors.Dark.background,
    onBackground = AppColors.Dark.onBackground,

    surface = AppColors.Dark.surface,
    onSurface = AppColors.Dark.onSurface,
    surfaceVariant = AppColors.Dark.surfaceVariant,
    onSurfaceVariant = AppColors.Dark.onSurfaceVariant,

    outline = AppColors.Dark.outline,
    outlineVariant = AppColors.Dark.outlineVariant,

    error = AppColors.Dark.error,
    onError = AppColors.Dark.onError,
    errorContainer = AppColors.Dark.errorContainer,
    onErrorContainer = AppColors.Dark.onErrorContainer
)

// ------------------------------------------------------------
// App Colors
// ------------------------------------------------------------

private val LocalAppColors = staticCompositionLocalOf {
    AppColors.Light
}

val MaterialTheme.appColors: AppColors
    @Composable
    get() = LocalAppColors.current

// ------------------------------------------------------------
// App Dimensions
// ------------------------------------------------------------

private val LocalAppDimensions = staticCompositionLocalOf {
    AppDimensions.Default
}

val MaterialTheme.appDimensions: AppDimensions
    @Composable
    get() = LocalAppDimensions.current

// ------------------------------------------------------------
// App Shapes
// ------------------------------------------------------------

private val LocalAppShapes = staticCompositionLocalOf {
    AppShapes.Default
}

val MaterialTheme.appShapes: AppShapes
    @Composable
    get() = LocalAppShapes.current

// ------------------------------------------------------------
// App Typography
// ------------------------------------------------------------

private val LocalAppTypography = staticCompositionLocalOf {
    AppTypography.Default
}

val MaterialTheme.appTypography: AppTypography
    @Composable
    get() = LocalAppTypography.current

// ------------------------------------------------------------
// App Theme
// ------------------------------------------------------------

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val appColors = if (darkTheme) {
        AppColors.Dark
    } else {
        AppColors.Light
    }

    val appDimensions = AppDimensions.Default
    val appShapes = AppShapes.Default
    val appTypography = AppTypography.Default

    CompositionLocalProvider(
        LocalAppColors provides appColors,
        LocalAppDimensions provides appDimensions,
        LocalAppShapes provides appShapes,
        LocalAppTypography provides appTypography
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = appTypography.materialTypography,
            content = content
        )
    }
}
