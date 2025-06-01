package com.bor96dev.data

import com.google.gson.annotations.SerializedName

data class ResponseDto(
    @SerializedName("offers")
    val offers: List<OfferDto>,

    @SerializedName("vacancies")
    val vacancies: List<VacancyDto>
)

data class OfferDto(
    @SerializedName("id")
    val id: String?,
    @SerializedName("title")
    val title: String,
    @SerializedName("button")
    val button: ButtonDto?,
    @SerializedName("link")
    val link: String
)

data class ButtonDto(
    @SerializedName("text")
    val text: String
)

data class VacancyDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("lookingNumber")
    val lookingNumber: Int?,
    @SerializedName("title")
    val title: String,
    @SerializedName("address")
    val address: AddressDto,
    @SerializedName("company")
    val company: String,
    @SerializedName("experience")
    val experience: ExperienceDto,
    @SerializedName("publishedDate")
    val publishedDate: String,
    @SerializedName("isFavorite")
    val isFavorite: Boolean
)

data class AddressDto(
    @SerializedName("town")
    val town: String,
)

data class ExperienceDto(
    @SerializedName("previewText")
    val previewText: String,
)