package com.shokhrukhyusupov.music.domain.models

data class Track(
    val id: String,
    val title: String,
    val artistId: String,
    val albumId: String,
    val duration: Long,
    val coverUrl: String?,
)
