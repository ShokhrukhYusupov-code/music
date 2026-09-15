package com.shokhrukhyusupov.music.domain.repositories

import com.shokhrukhyusupov.music.domain.models.Track

interface TrackRepository {
    suspend fun getTracks(): Result<List<Track>>
    suspend fun getTrack(id: String): Result<Track>
}