package com.shokhrukhyusupov.music.presentation.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shokhrukhyusupov.music.R
import com.shokhrukhyusupov.music.domain.repositories.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onPhoneChanged(phone: String) {
        _uiState.update { it.copy(phone = phone, error = null) }
    }

    fun onPasswordChanged(password: String) {
        _uiState.update { it.copy(password = password, error = null) }
    }

    fun onPasswordVisibilityChanged(passwordVisible: Boolean) {
        _uiState.update { it.copy(passwordVisible = passwordVisible) }
    }

    fun login() {
        val currentState = _uiState.value

        val phoneError = if (currentState.phone.isBlank()) {
            R.string.error_phone_required
        } else {
            null
        }

        val passwordError = when {
            currentState.password.isBlank() -> R.string.error_password_required
            currentState.password.length < 6 -> R.string.error_password_short
            else -> null
        }

        if (phoneError != null || passwordError != null) {
            _uiState.update {
                it.copy(
                    phoneError = phoneError,
                    passwordError = passwordError
                )
            }

            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            val result = authRepository.login(
                currentState.phone,
                currentState.password
            )

            _uiState.update { it.copy(isLoading = false) }

            result.onFailure { throwable ->
                _uiState.update {
                    it.copy(error = throwable.localizedMessage ?: "Ошибка входа")
                }
            }
        }
    }
}
