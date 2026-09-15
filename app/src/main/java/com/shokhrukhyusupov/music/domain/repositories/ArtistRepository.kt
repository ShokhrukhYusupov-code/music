package com.shokhrukhyusupov.music.domain.repositories

import com.shokhrukhyusupov.music.domain.models.Artist

interface ArtistRepository {
    suspend fun getArtists(): Result<List<Artist>>
    suspend fun getArtist(id: String): Result<Artist>
}