package com.bor96dev.domain

data class Vacancy (
    val id: String,
    val lookingNumber: Int?,
    val title: String,
    val city: Address,
    val companyName: String,
    val experience: Experience,
    val publishedDate: String,
    val isFavorite: Boolean
)

data class Address(
    val town: String
)

data class Experience(
    val previewText: String
)
