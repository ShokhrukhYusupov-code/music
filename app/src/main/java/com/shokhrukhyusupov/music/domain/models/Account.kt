package com.shokhrukhyusupov.music.domain.models

import java.time.LocalDate

data class Account(
    val id: String,
    val name: String,
    val surname: String,
    val dateOfBirth: LocalDate,
    val phone: String,
)
