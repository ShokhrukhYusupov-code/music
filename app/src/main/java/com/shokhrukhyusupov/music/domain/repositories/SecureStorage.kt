package com.shokhrukhyusupov.music.domain.repositories

import kotlinx.coroutines.flow.Flow

interface SecureStorage {
    val accessTokenFlow: Flow<String?>
    suspend fun saveTokens(accessToken: String, refreshToken: String)
    suspend fun clearTokens()
}