package com.bor96dev.domain

interface VacancyRepository {

    suspend fun loadVacancies(): Pair<Boolean,List<Vacancy>>

    suspend fun loadRecommendations(): Pair<Boolean, List<Recommendation>>
}