package com.shokhrukhyusupov.music.data.repositories

import com.shokhrukhyusupov.music.domain.repositories.AuthRepository
import com.shokhrukhyusupov.music.domain.repositories.SecureStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val secureStorage: SecureStorage
) : AuthRepository {

    override suspend fun login(phone: String, password: String): Result<Unit> {
        return withContext(Dispatchers.IO) {
            if (phone == "+998904804480" && password == "password") {
                secureStorage.saveTokens(
                    accessToken = "fake_access_token",
                    refreshToken = "fake_refresh_token"
                )
                Result.success(Unit)
            } else {
                Result.failure(Throwable("Неверный логин или пароль"))
            }
        }
    }

    override suspend fun register(phone: String, password: String): Result<Unit> {
        return withContext(Dispatchers.IO) {
            // При успешной регистрации сохраняем фейковые токены, чтобы пользователь сразу вошел
            secureStorage.saveTokens(
                accessToken = "fake_access_token",
                refreshToken = "fake_refresh_token"
            )
            Result.success(Unit)
        }
    }

    override suspend fun logout() {
        withContext(Dispatchers.IO) {
            try {
                // Пока сети нет, просто очищаем локальное хранилище токенов
                secureStorage.clearTokens()
            } catch (_: Exception) {
                // Исключения на всякий случай
            }
        }
    }
}