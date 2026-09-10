package com.shokhrukhyusupov.music.domain.storage

import com.shokhrukhyusupov.music.domain.models.AuthTokens

interface TokenStorage {

    fun saveTokens(tokens: AuthTokens)

    fun getTokens(): AuthTokens?

    fun clearTokens()
}
