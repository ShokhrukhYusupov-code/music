package com.shokhrukhyusupov.music.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.shokhrukhyusupov.music.presentation.theme.appColors
import com.shokhrukhyusupov.music.presentation.theme.appDimensions
import com.shokhrukhyusupov.music.presentation.theme.components.AppTextField
import com.shokhrukhyusupov.music.presentation.theme.components.phoneNumberField.CountryInfo
import com.shokhrukhyusupov.music.presentation.theme.components.phoneNumberField.CountryPicker
import com.shokhrukhyusupov.music.presentation.theme.components.phoneNumberField.PhoneNumberTextField
import com.shokhrukhyusupov.music.presentation.theme.components.phoneNumberField.PhoneNumberUtils.isoToEmojiFlag
import java.util.Locale

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onLoginSuccess: () -> Unit
) {
    val dimensions = MaterialTheme.appDimensions
    val colorScheme = MaterialTheme.appColors
    val typography = MaterialTheme.typography

    var phone by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.isSuccess) {
        if (uiState.isSuccess) {
            viewModel.resetSuccess()
            onLoginSuccess()
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = dimensions.screenPadding
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = dimensions.spacingLarge,
                alignment = Alignment.CenterVertically
            )
        ) {
            Text(
                text = "Login",
                modifier = Modifier.align(
                    Alignment.Start
                ),
                style = typography.headlineLarge
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(
                    space = dimensions.spacingSmall,
                    alignment = Alignment.CenterVertically
                )
            ) {

                PhoneNumberTextField(
                    value = phone,
                    onValueChange = {
                        phone = it
                    },
                    textStyle = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onSurface,
                    ),
                    label = {
                        Text("Phone number")
                    },
                    enabled = !uiState.isLoading,
                    modifier = Modifier.fillMaxWidth()
                )

                AppTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    enabled = !uiState.isLoading,
                    label = {
                        Text("Password")
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Password,
                            contentDescription = "Password"
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            if (uiState.error != null) {
                Text(
                    text = uiState.error!!,
                    style = typography.bodySmall,
                    color = colorScheme.error
                )
            }

            Button(
                onClick = {
                    viewModel.login(
                        email = phone,
                        password = password
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !uiState.isLoading
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        strokeWidth = 2.dp
                    )
                } else {
                    Text("Sign in")
                }
            }
        }
    }
}
