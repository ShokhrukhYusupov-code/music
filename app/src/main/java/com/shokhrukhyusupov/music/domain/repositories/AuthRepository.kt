package com.shokhrukhyusupov.music.domain.repositories

import com.shokhrukhyusupov.music.domain.models.AuthTokens

interface AuthRepository {

    suspend fun login(email: String, password: String): Result<AuthTokens>

    suspend fun register(email: String, password: String): Result<AuthTokens>
}
