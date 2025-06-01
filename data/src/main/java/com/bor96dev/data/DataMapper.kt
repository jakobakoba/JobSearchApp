package com.bor96dev.data

import com.bor96dev.domain.Address
import com.bor96dev.domain.Experience
import com.bor96dev.domain.Recommendation
import com.bor96dev.domain.Vacancy

fun VacancyDto.toDomain(): Vacancy = Vacancy(
    id = id,
    lookingNumber = lookingNumber,
    title = title,
    address = Address(town = address.town),
    company = company,
    experience = Experience(previewText = experience.previewText),
    publishedDate = publishedDate,
    isFavorite = isFavorite,
)

fun OfferDto.toDomain(): Recommendation = Recommendation(
    id = id,
    title = title,
    button = button?.text,
    link = link
)