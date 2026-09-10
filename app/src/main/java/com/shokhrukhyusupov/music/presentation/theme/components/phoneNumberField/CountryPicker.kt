package com.shokhrukhyusupov.music.presentation.theme.components.phoneNumberField

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextOverflow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryPicker(
    countries: List<CountryInfo>,
    onCountrySelected: (CountryInfo) -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,

    title: String = "Choose a country",
    searchPlaceholder: String = "Search",
    showSearch: Boolean = true,

    containerColor: Color = MaterialTheme.colorScheme.surface,
    shape: RoundedCornerShape = RoundedCornerShape(
        topStart = 28.dp,
        topEnd = 28.dp
    ),
    elevation: Dp = 4.dp
) {
    var isSearching by rememberSaveable {
        mutableStateOf(false)
    }

    var searchQuery by rememberSaveable {
        mutableStateOf("")
    }

    val focusRequester = remember {
        FocusRequester()
    }

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    LaunchedEffect(isSearching) {
        if (isSearching) {
            focusRequester.requestFocus()
        }
    }

    val filteredCountries = remember(
        countries,
        searchQuery
    ) {
        if (searchQuery.isBlank()) {
            countries
        } else {
            countries.filter { country ->
                country.name.contains(
                    searchQuery,
                    ignoreCase = true
                ) ||
                        country.code.contains(
                            searchQuery,
                            ignoreCase = true
                        ) ||
                        country.dialCode.contains(searchQuery)
            }
        }
    }

    ModalBottomSheet(
        modifier = modifier,
        sheetState = sheetState,
        onDismissRequest = {
            isSearching = false
            searchQuery = ""
            onDismiss()
        },
        containerColor = containerColor,
        tonalElevation = 0.dp,
        contentWindowInsets = {
            WindowInsets(0, 0, 0, 0)
        },
        dragHandle = {

            TopAppBar(
                modifier = Modifier.shadow(
                    elevation = 1.dp,
                    shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
                ),

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = containerColor
                ),

                navigationIcon = {
                    IconButton(
                        onClick = {
                            if (isSearching) {
                                isSearching = false
                                searchQuery = ""
                            } else {
                                onDismiss()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },

                title = {
                    if (isSearching) {
                        CountrySearchField(
                            value = searchQuery,
                            onValueChange = {
                                searchQuery = it
                            },
                            placeholder = searchPlaceholder,
                            focusRequester = focusRequester
                        )
                    } else {
                        Text(
                            text = title,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                },


                actions = {
                    if (showSearch && !isSearching) {
                        IconButton(
                            onClick = {
                                isSearching = true
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search"
                            )
                        }
                    }
                }
            )
        }
    ) {

        CountryList(
            modifier = Modifier.fillMaxSize(),
            countries = filteredCountries,
            onCountrySelected = { country ->
                onCountrySelected(country)
                onDismiss()
            }
        )
    }
}