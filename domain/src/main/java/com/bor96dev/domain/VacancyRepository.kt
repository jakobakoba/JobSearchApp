package com.bor96dev.domain

interface VacancyRepository {

    suspend fun loadVacancies(): List<Vacancy>
    suspend fun loadRecommendations(): List<Recommendation>
    suspend fun toggleFavorite(vacancy: Vacancy)
    suspend fun getFavorites(): List<Vacancy>
    suspend fun getFavoritesCount(): Int
}