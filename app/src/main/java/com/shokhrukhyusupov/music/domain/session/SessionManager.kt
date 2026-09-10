package com.shokhrukhyusupov.music.domain.session

import com.shokhrukhyusupov.music.domain.models.AuthTokens

interface SessionManager {

    fun checkAuth(): Boolean

    fun startSession(tokens: AuthTokens)

    fun logout()
}
