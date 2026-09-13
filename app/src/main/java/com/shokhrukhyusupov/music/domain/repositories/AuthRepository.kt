package com.shokhrukhyusupov.music.domain.repositories

interface AuthRepository {
    suspend fun login(phone: String, password: String): Result<Unit>
    suspend fun register(phone: String, password: String): Result<Unit>
    suspend fun logout()
}
