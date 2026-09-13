package com.shokhrukhyusupov.music.presentation.auth.login

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.shokhrukhyusupov.music.R
import com.shokhrukhyusupov.music.core.ui.theme.button
import com.shokhrukhyusupov.music.core.ui.components.phoneNumberField.PhoneNumberTextField
import com.shokhrukhyusupov.music.core.ui.theme.dimensions

@Composable
fun LoginScreen(
    state: LoginUiState,
    onPhoneChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onPasswordVisibilityChanged: (Boolean) -> Unit,
    onLoginClick: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val dimensions = MaterialTheme.dimensions
    val typography = MaterialTheme.typography

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = dimensions.spacingExtraLarge,
                alignment = Alignment.CenterVertically
            ),
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = dimensions.screenPadding)
        ) {
            Text(
                text = stringResource(R.string.login),
                style = typography.headlineLarge,
                modifier = Modifier.align(Alignment.Start)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    space = dimensions.spacingSmall,
                    alignment = Alignment.CenterVertically
                )
            ) {
                LoginField(
                    phone = state.phone,
                    onPhoneChanged = onPhoneChanged,
                    enabled = !state.isLoading,
                    phoneError = state.phoneError
                )
                PasswordField(
                    password = state.password,
                    onPasswordChanged = onPasswordChanged,
                    enabled = !state.isLoading,
                    passwordError = state.passwordError,
                    passwordVisible = state.passwordVisible,
                    onPasswordVisibilityChanged = onPasswordVisibilityChanged
                )
            }
            PrimaryButton(
                onClick = {
                    focusManager.clearFocus()
                    onLoginClick()
                },
                text = stringResource(R.string.sign_in),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun LoginField(
    phone: String = "",
    onPhoneChanged: (String) -> Unit = {},
    enabled: Boolean = true,
    @StringRes phoneError: Int? = null,
) {
    PhoneNumberTextField(
        value = phone,
        onValueChange = onPhoneChanged,
        enabled = enabled,
        isError = phoneError != null,
        supportingText = phoneError?.let { error ->
            { Text(stringResource(error)) }
        },
        label = { Text(stringResource(R.string.phone_number)) },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun PasswordField(
    password: String = "",
    onPasswordChanged: (String) -> Unit = {},
    enabled: Boolean = true,
    @StringRes passwordError: Int? = null,
    passwordVisible: Boolean = false,
    onPasswordVisibilityChanged: (Boolean) -> Unit = {},
) {
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChanged,
        enabled = enabled,
        isError = passwordError != null,
        supportingText = passwordError?.let { error ->
            { Text(stringResource(error)) }
        },
        visualTransformation = if (passwordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        label = { Text(stringResource(R.string.password)) },
        placeholder = { Text(stringResource(R.string.enter_password)) },
        trailingIcon = {
            IconButton(onClick = { onPasswordVisibilityChanged(!passwordVisible) }) {
                Icon(
                    imageVector = if (passwordVisible) {
                        Icons.Default.Visibility
                    } else {
                        Icons.Default.VisibilityOff
                    },
                    contentDescription = if (passwordVisible) {
                        stringResource(R.string.hide_password)
                    } else {
                        stringResource(R.string.show_password)
                    }
                )
            }
        },
        singleLine = true,
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    enabled: Boolean = true,
    text: String,
    modifier: Modifier,
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = MaterialTheme.shapes.small,
        modifier = modifier.height(MaterialTheme.dimensions.buttonHeight)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.button
        )
    }
}