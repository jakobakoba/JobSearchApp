package com.bor96dev.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bor96dev.domain.Recommendation
import com.bor96dev.domain.Vacancy
import com.bor96dev.domain.VacancyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val vacancyRepository: VacancyRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)

            val vacancies = vacancyRepository.loadVacancies()
            val recommendations = vacancyRepository.loadRecommendations()

            _uiState.value = _uiState.value.copy(
                isLoading = false,
                vacancies = vacancies,
                recommendations = recommendations,
            )
        }
    }

    fun toggleFavorite(vacancy: Vacancy) {
        viewModelScope.launch {
            val updatedVacancy = vacancy.copy(isFavorite = !vacancy.isFavorite)
            vacancyRepository.toggleFavorite(updatedVacancy)

            val updatedVacancies = _uiState.value.vacancies.map {
                if (it.id == vacancy.id) updatedVacancy else it
            }
            _uiState.value = _uiState.value.copy(vacancies = updatedVacancies)
        }
    }
}

data class MainUiState(
    val isLoading: Boolean = false,
    val vacancies: List<Vacancy> = emptyList(),
    val recommendations: List<Recommendation> = emptyList(),
    val showAllVacancies: Boolean = false
)