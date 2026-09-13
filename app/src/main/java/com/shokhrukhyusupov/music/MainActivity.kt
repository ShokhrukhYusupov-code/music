package com.shokhrukhyusupov.music

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.shokhrukhyusupov.music.domain.managers.SessionState
import com.shokhrukhyusupov.music.presentation.main.MainViewModel
import com.shokhrukhyusupov.music.core.navigation.AppNavHost
import com.shokhrukhyusupov.music.core.navigation.AppRoute
import com.shokhrukhyusupov.music.core.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        splashScreen.setKeepOnScreenCondition {
            viewModel.authState.value is SessionState.Loading
        }

        setContent {
            AppTheme {
                val authState by viewModel.authState.collectAsState()

                when (authState) {
                    is SessionState.Loading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                    is SessionState.Authenticated -> {
                        AppNavHost(startDestination = AppRoute.Main.Home)
                    }
                    is SessionState.Unauthenticated -> {
                        AppNavHost(startDestination = AppRoute.Login)
                    }
                }
            }
        }
    }
}