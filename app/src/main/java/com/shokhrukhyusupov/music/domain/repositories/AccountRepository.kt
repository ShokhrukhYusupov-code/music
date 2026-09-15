package com.shokhrukhyusupov.music.domain.repositories

import com.shokhrukhyusupov.music.domain.models.Account

interface AccountRepository {
    suspend fun getAccount(): Result<Account>
    suspend fun updateAccount(account: Account): Result<Unit>
}