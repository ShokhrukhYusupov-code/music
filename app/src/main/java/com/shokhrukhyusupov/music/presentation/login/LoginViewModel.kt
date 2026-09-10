package com.shokhrukhyusupov.music.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shokhrukhyusupov.music.domain.repositories.AuthRepository
import com.shokhrukhyusupov.music.domain.session.SessionManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository,
    private val sessionManager: SessionManager
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    fun login(
        email: String,
        password: String
    ) {
        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(
                isLoading = true,
                error = null,
                isSuccess = false
            )

            val result = authRepository.login(
                email = email,
                password = password
            )

            result.onSuccess { tokens ->

                sessionManager.startSession(tokens)

                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isSuccess = true,
                    error = null
                )
            }

            result.onFailure { exception ->

                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isSuccess = false,
                    error = exception.message ?: "Ошибка авторизации"
                )
            }
        }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(
            error = null
        )
    }

    fun resetSuccess() {
        _uiState.value = _uiState.value.copy(
            isSuccess = false
        )
    }
}
