package com.shokhrukhyusupov.music.presentation.auth.login

import androidx.annotation.StringRes

data class LoginUiState(
    val phone: String = "",
    val password: String = "",
    @StringRes val phoneError: Int? = null,
    @StringRes val passwordError: Int? = null,
    val passwordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)
