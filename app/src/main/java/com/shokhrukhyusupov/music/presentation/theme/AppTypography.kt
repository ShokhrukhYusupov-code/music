package com.shokhrukhyusupov.music.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class AppTypography(
    // Display
    val displayLarge: TextStyle,
    val displayMedium: TextStyle,
    val displaySmall: TextStyle,

    // Headlines
    val headlineLarge: TextStyle,
    val headlineMedium: TextStyle,
    val headlineSmall: TextStyle,

    // Titles
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,

    // Body
    val bodyLarge: TextStyle,
    val bodyMedium: TextStyle,
    val bodySmall: TextStyle,

    // Labels
    val labelLarge: TextStyle,
    val labelMedium: TextStyle,
    val labelSmall: TextStyle,

    // Music
    val trackTitle: TextStyle,
    val artistName: TextStyle,
    val albumTitle: TextStyle,
    val playerTitle: TextStyle,
    val playerArtist: TextStyle,
    val duration: TextStyle
) {

    val materialTypography: Typography
        get() = Typography(
            displayLarge = displayLarge,
            displayMedium = displayMedium,
            displaySmall = displaySmall,

            headlineLarge = headlineLarge,
            headlineMedium = headlineMedium,
            headlineSmall = headlineSmall,

            titleLarge = titleLarge,
            titleMedium = titleMedium,
            titleSmall = titleSmall,

            bodyLarge = bodyLarge,
            bodyMedium = bodyMedium,
            bodySmall = bodySmall,

            labelLarge = labelLarge,
            labelMedium = labelMedium,
            labelSmall = labelSmall
        )

    companion object {

        val Default = AppTypography(

            // Display
            displayLarge = TextStyle(
                fontSize = 57.sp,
                lineHeight = 64.sp,
                fontWeight = FontWeight.Normal
            ),

            displayMedium = TextStyle(
                fontSize = 45.sp,
                lineHeight = 52.sp,
                fontWeight = FontWeight.Normal
            ),

            displaySmall = TextStyle(
                fontSize = 36.sp,
                lineHeight = 44.sp,
                fontWeight = FontWeight.Normal
            ),

            // Headlines
            headlineLarge = TextStyle(
                fontSize = 32.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight.Bold
            ),

            headlineMedium = TextStyle(
                fontSize = 28.sp,
                lineHeight = 36.sp,
                fontWeight = FontWeight.Bold
            ),

            headlineSmall = TextStyle(
                fontSize = 24.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight.Bold
            ),

            // Titles
            titleLarge = TextStyle(
                fontSize = 22.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.SemiBold
            ),

            titleMedium = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.SemiBold
            ),

            titleSmall = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.SemiBold
            ),

            // Body
            bodyLarge = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Normal
            ),

            bodyMedium = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Normal
            ),

            bodySmall = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.Normal
            ),

            // Labels
            labelLarge = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.SemiBold
            ),

            labelMedium = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.SemiBold
            ),

            labelSmall = TextStyle(
                fontSize = 11.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.SemiBold
            ),

            // Music
            trackTitle = TextStyle(
                fontSize = 16.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.SemiBold
            ),

            artistName = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Normal
            ),

            albumTitle = TextStyle(
                fontSize = 20.sp,
                lineHeight = 26.sp,
                fontWeight = FontWeight.Bold
            ),

            playerTitle = TextStyle(
                fontSize = 24.sp,
                lineHeight = 30.sp,
                fontWeight = FontWeight.Bold
            ),

            playerArtist = TextStyle(
                fontSize = 16.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.Normal
            ),

            duration = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.Medium
            )
        )
    }
}
