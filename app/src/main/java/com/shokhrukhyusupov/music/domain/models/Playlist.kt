package com.shokhrukhyusupov.music.domain.models

data class Playlist(
    val id: String,
    val title: String,
    val userId: String,
    val coverUrl: String?,
    val trackIds: List<String>,
)