package com.shokhrukhyusupov.music.core.ui.components.phoneNumberField

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CountryList(
    modifier: Modifier = Modifier,
    countries: List<CountryInfo>,
    onCountrySelected: (CountryInfo) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = countries,
            key = { country -> country.code }
        ) { country ->
            CountryItem(
                country = country,
                onCountrySelected = onCountrySelected
            )
        }
    }
}
