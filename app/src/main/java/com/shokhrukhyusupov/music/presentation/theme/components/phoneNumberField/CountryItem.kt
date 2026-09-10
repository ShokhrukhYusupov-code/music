package com.shokhrukhyusupov.music.presentation.theme.components.phoneNumberField

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CountryItem(
    country: CountryInfo,
    onCountrySelected: (CountryInfo) -> Unit
) {
    ListItem(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { onCountrySelected(country) }
            .padding(horizontal = 12.dp),
        colors = ListItemDefaults.colors(
            containerColor = Color.Transparent
        ),
        leadingContent = {
            Text(
                text = country.flagEmoji,
                fontSize = 20.sp
            )
        },
        headlineContent = {
            Text(
                text = country.name,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        supportingContent = {
            Text(
                text = country.code,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        trailingContent = {
            Text(
                text = country.dialCode,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    )
}
