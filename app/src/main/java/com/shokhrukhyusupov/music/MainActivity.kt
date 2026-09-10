package com.shokhrukhyusupov.music

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController

import com.shokhrukhyusupov.music.core.navigation.AppNavHost
import com.shokhrukhyusupov.music.data.local.storage.SharedPreferencesTokenStorage
import com.shokhrukhyusupov.music.data.repositories.AuthRepositoryImpl
import com.shokhrukhyusupov.music.data.session.SessionManagerImpl
import com.shokhrukhyusupov.music.presentation.login.LoginViewModelFactory
import com.shokhrukhyusupov.music.presentation.theme.AppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val preferences = getSharedPreferences(
            "music_preferences",
            MODE_PRIVATE
        )

        val tokenStorage = SharedPreferencesTokenStorage(
            preferences = preferences
        )

        val sessionManager = SessionManagerImpl(
            tokenStorage = tokenStorage
        )

        val authRepository = AuthRepositoryImpl()

        val loginViewModelFactory = LoginViewModelFactory(
            authRepository = authRepository,
            sessionManager = sessionManager
        )

        setContent {
            AppTheme {

                val navController = rememberNavController()

                AppNavHost(
                    navController = navController,
                    loginViewModelFactory = loginViewModelFactory
                )
            }
        }
    }
}
