package com.shokhrukhyusupov.music.core.ui.components.phoneNumberField

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults.FocusedBorderThickness
import androidx.compose.material3.OutlinedTextFieldDefaults.UnfocusedBorderThickness
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.shokhrukhyusupov.music.core.ui.theme.dimensions
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneNumberTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    isError: Boolean = false,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge.copy(
        color = MaterialTheme.colorScheme.onSurface,
    ),
    shape: Shape = MaterialTheme.shapes.small,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    dividerColor: Color = MaterialTheme.colorScheme.outlineVariant
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }

    val countries = remember {
        val phoneUtil = PhoneNumberUtil.getInstance()

        Locale.getISOCountries().mapNotNull { isoCode ->
            val dialCode = phoneUtil.getCountryCodeForRegion(isoCode)

            if (dialCode <= 0) {
                return@mapNotNull null
            }

            val countryLocale = Locale.Builder().setRegion(isoCode).build()

            CountryInfo(
                code = isoCode,
                name = countryLocale.getDisplayCountry(Locale.getDefault()),
                dialCode = "+$dialCode",
                flagEmoji = PhoneNumberUtils.isoToEmojiFlag(isoCode)
            )
        }.sortedBy {
            it.name
        }
    }

    var selectedCountryCode by rememberSaveable {
        mutableStateOf("UZ")
    }

    val selectedCountry = remember(
        countries, selectedCountryCode
    ) {
        countries.firstOrNull {
            it.code == selectedCountryCode
        } ?: countries.first()
    }

    var showCountryPicker by remember {
        mutableStateOf(false)
    }

    val mask = remember(
        selectedCountry.code
    ) {
        PhoneMasks.getMask(selectedCountry.code)
    }

    val maxLength = remember(mask) {
        PhoneMasks.getMaxLengthFromMask(mask)
    }

    val placeholderColor = MaterialTheme.colorScheme.onSurfaceVariant

    val visualTransformation = remember(
        mask, placeholderColor
    ) {
        PhoneNumberVisualTransformation(
            mask = mask, placeholderColor = placeholderColor
        )
    }

    val localValue = remember(value, selectedCountry.dialCode) {
        if (value.startsWith(selectedCountry.dialCode)) {
            value.removePrefix(selectedCountry.dialCode)
        } else {
            PhoneNumberUtils.digitsOnly(value)
        }
    }

    BasicTextField(
        value = localValue,
        onValueChange = { newValue ->
            val digitsOnly = PhoneNumberUtils.digitsOnly(newValue)

            if (digitsOnly.length <= maxLength) {
                onValueChange(selectedCountry.dialCode + digitsOnly)
            }
        },
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        singleLine = true,
        textStyle = textStyle,
        cursorBrush = SolidColor(
            MaterialTheme.colorScheme.primary
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone
        ),
        visualTransformation = visualTransformation,
        interactionSource = interactionSource,
        decorationBox = { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(
                value = localValue,
                innerTextField = innerTextField,
                enabled = enabled,
                singleLine = true,
                visualTransformation = visualTransformation,
                interactionSource = interactionSource,
                isError = isError,
                label = label,
                supportingText = supportingText,
                leadingIcon = {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(end = 8.dp)
                            .clickable(
                                enabled = enabled,
                                onClick = {
                                    showCountryPicker = true
                                }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(
                                    horizontal = 14.dp
                                ),
                            horizontalArrangement = Arrangement.spacedBy(
                                8.dp
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = selectedCountry.flagEmoji
                            )

                            Text(
                                text = selectedCountry.dialCode,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Icon(
                                modifier = Modifier
                                    .size(8.dp)
                                    .requiredSize(
                                        16.dp
                                    ),
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = "Choose country"
                            )
                        }

                        VerticalDivider(
                            thickness = 1.dp,
                            color = dividerColor,
                            modifier = Modifier
                                .height(MaterialTheme.dimensions.textFieldHeight)
                                .padding(vertical = MaterialTheme.dimensions.paddingMedium)
                        )
                    }
                },
                trailingIcon = trailingIcon,
                colors = colors,
                contentPadding = OutlinedTextFieldDefaults.contentPadding(),
                container = {
                    OutlinedTextFieldDefaults.Container(
                        enabled = enabled,
                        isError = isError,
                        interactionSource = interactionSource,
                        colors = colors,
                        shape = shape,
                        focusedBorderThickness = FocusedBorderThickness,
                        unfocusedBorderThickness = UnfocusedBorderThickness
                    )
                }
            )
        }
    )

    if (showCountryPicker) {
        CountryPicker(
            modifier = Modifier.fillMaxWidth(),
            countries = countries,
            onCountrySelected = { country ->
                selectedCountryCode = country.code
                // При смене страны сразу обновляем value на новый код страны
                onValueChange(country.dialCode)
                showCountryPicker = false
            },
            onDismiss = {
                showCountryPicker = false
            }
        )
    }
}