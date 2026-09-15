package com.shokhrukhyusupov.music.domain.repositories

import com.shokhrukhyusupov.music.domain.models.Playlist

interface PlaylistRepository {
    suspend fun getPlaylists(): Result<List<Playlist>>
    suspend fun getPlaylist(id: String): Result<Playlist>
    suspend fun createPlaylist(name: String): Result<Playlist>
}