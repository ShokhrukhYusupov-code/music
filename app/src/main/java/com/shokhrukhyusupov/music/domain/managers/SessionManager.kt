package com.shokhrukhyusupov.music.domain.managers

import com.shokhrukhyusupov.music.domain.repositories.SecureStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import javax.inject.Singleton

sealed interface SessionState {
    data object Loading : SessionState
    data object Authenticated : SessionState
    data object Unauthenticated : SessionState
}

@Singleton
class SessionManager @Inject constructor(
    secureStorage: SecureStorage
) {
    private val externalScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    val authState: StateFlow<SessionState> = secureStorage.accessTokenFlow
        .map { token ->
            if (token.isNullOrBlank()) {
                SessionState.Unauthenticated
            } else {
                SessionState.Authenticated
            }
        }
        .stateIn(
            scope = externalScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = SessionState.Loading
        )
}