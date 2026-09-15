package com.shokhrukhyusupov.music.presentation.settings

data class SettingsUiState(
    val appVersion: String = "v1.0.4 (Build 140)",
    val isLoading: Boolean = false,
    val error: String? = null
)