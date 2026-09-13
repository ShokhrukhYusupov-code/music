package com.shokhrukhyusupov.music.core.di

import com.shokhrukhyusupov.music.data.local.SecureStorageImpl
import com.shokhrukhyusupov.music.domain.repositories.SecureStorage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {

    @Binds
    @Singleton
    abstract fun bindSecureStorage(
        impl: SecureStorageImpl
    ): SecureStorage
}