package com.shokhrukhyusupov.music.domain.repositories

import com.shokhrukhyusupov.music.domain.models.User

interface UserRepository {
    suspend fun getUser(): Result<User>
    suspend fun updateUser(user: User): Result<Unit>
}