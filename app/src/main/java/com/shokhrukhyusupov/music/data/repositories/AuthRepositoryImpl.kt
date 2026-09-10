package com.shokhrukhyusupov.music.data.repositories

import com.shokhrukhyusupov.music.domain.models.AuthTokens
import com.shokhrukhyusupov.music.domain.repositories.AuthRepository

class AuthRepositoryImpl : AuthRepository {

    override suspend fun login(
        email: String,
        password: String
    ): Result<AuthTokens> {
        // Здесь позже будет API-запрос

        return Result.success(
            AuthTokens(
                accessToken = "fake_access_token",
                refreshToken = "fake_refresh_token"
            )
        )
    }

    override suspend fun register(
        email: String,
        password: String
    ): Result<AuthTokens> {
        // Здесь позже будет API-запрос

        return Result.success(
            AuthTokens(
                accessToken = "fake_access_token",
                refreshToken = "fake_refresh_token"
            )
        )
    }
}
