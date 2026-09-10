package com.shokhrukhyusupov.music.data.local.storage

import android.content.SharedPreferences
import com.shokhrukhyusupov.music.domain.models.AuthTokens
import com.shokhrukhyusupov.music.domain.storage.TokenStorage
import androidx.core.content.edit

class SharedPreferencesTokenStorage(
    private val preferences: SharedPreferences
) : TokenStorage {

    override fun saveTokens(tokens: AuthTokens) {
        preferences.edit {
            putString(ACCESS_TOKEN_KEY, tokens.accessToken)
            putString(REFRESH_TOKEN_KEY, tokens.refreshToken)
        }
    }

    override fun getTokens(): AuthTokens? {
        val accessToken = preferences.getString(ACCESS_TOKEN_KEY, null)
        val refreshToken = preferences.getString(REFRESH_TOKEN_KEY, null)

        if (accessToken == null || refreshToken == null) {
            return null
        }

        return AuthTokens(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }

    override fun clearTokens() {
        preferences.edit {
            remove(ACCESS_TOKEN_KEY)
            remove(REFRESH_TOKEN_KEY)
        }
    }

    private companion object {
        const val ACCESS_TOKEN_KEY = "access_token"
        const val REFRESH_TOKEN_KEY = "refresh_token"
    }
}

