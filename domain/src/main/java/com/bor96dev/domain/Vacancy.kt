package com.bor96dev.domain

data class Vacancy (
    val lookingNumber: Int,
    val title: String,
    val city: String,
    val companyName: String,
    val publishedDate: String,
    val isFavorite: Boolean
)
