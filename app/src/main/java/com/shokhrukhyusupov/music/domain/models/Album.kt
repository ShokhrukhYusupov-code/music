package com.shokhrukhyusupov.music.domain.models

data class Album(
    val id: String,
    val title: String,
    val coverUrl: String,
    val artistId: String,
)
