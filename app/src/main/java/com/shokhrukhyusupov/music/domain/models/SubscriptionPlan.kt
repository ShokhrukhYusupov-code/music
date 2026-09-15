package com.shokhrukhyusupov.music.domain.models

data class SubscriptionPlan(
    val id: String,
    val title: String,
    val price: String,
    val durationMonths: Int
)