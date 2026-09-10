package com.shokhrukhyusupov.music.data.session

import com.shokhrukhyusupov.music.domain.models.AuthTokens
import com.shokhrukhyusupov.music.domain.session.SessionManager
import com.shokhrukhyusupov.music.domain.storage.TokenStorage

class SessionManagerImpl(
    private val tokenStorage: TokenStorage
) : SessionManager {

    override fun checkAuth(): Boolean {
        return tokenStorage.getTokens() != null
    }

    override fun startSession(tokens: AuthTokens) {
        tokenStorage.saveTokens(tokens)
    }

    override fun logout() {
        tokenStorage.clearTokens()
    }
}
