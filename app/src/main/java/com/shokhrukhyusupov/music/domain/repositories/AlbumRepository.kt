package com.shokhrukhyusupov.music.domain.repositories

import com.shokhrukhyusupov.music.domain.models.Album

interface AlbumRepository {
    suspend fun getAlbums(): Result<List<Album>>
    suspend fun getAlbum(id: String): Result<Album>
}