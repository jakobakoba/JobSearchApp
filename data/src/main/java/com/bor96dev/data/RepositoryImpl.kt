package com.bor96dev.data

import com.bor96dev.data.local.FavoriteStorage
import com.bor96dev.domain.Recommendation
import com.bor96dev.domain.Vacancy
import com.bor96dev.domain.VacancyRepository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val mockDataSource: MockDataSource,
    private val favoriteStorage: FavoriteStorage
) : VacancyRepository {
    override suspend fun loadVacancies(): List<Vacancy> {
        val vacancies = mockDataSource.getVacancies()
        val favoriteIds = favoriteStorage.getFavoriteIds()

        val vacanciesWithFavorites = vacancies.map { vacancy ->
            vacancy.copy(isFavorite = favoriteIds.contains(vacancy.id))
        }
        return vacanciesWithFavorites
    }


    override suspend fun loadRecommendations(): List<Recommendation> {
        val recommendations = mockDataSource.getRecommendations()
        return recommendations
    }

    override suspend fun toggleFavorite(vacancy: Vacancy) {
        if (vacancy.isFavorite) {
            favoriteStorage.addToFavorites(vacancy.id)
        } else {
            favoriteStorage.removeFromFavorites(vacancy.id)
        }
    }

    override suspend fun getFavorites(): List<Vacancy> {
        val allVacancies = mockDataSource.getVacancies()
        val favoriteIds = favoriteStorage.getFavoriteIds()

        return allVacancies.filter { favoriteIds.contains(it.id) }
            .map { it.copy(isFavorite = true) }
    }

    override suspend fun getFavoritesCount(): Int {
        return favoriteStorage.getFavoritesCount()
    }

}