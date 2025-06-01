package com.bor96dev.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import com.bor96dev.presentation.MainViewModel
import com.bor96dev.presentation.composables.SearchHeaderExpanded
import com.bor96dev.presentation.composables.SearchHeaderNormal
import com.bor96dev.presentation.composables.ShowMoreButton
import com.bor96dev.presentation.composables.VacancyItem

@Composable
fun SearchScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var showAllVacancies by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        if (showAllVacancies) {
            SearchHeaderExpanded(
                vacanciesCount = uiState.vacancies.size,
                onBackClick = { showAllVacancies = false }
            )
        } else {
            SearchHeaderNormal(recommendations = uiState.recommendations)
        }

        LazyColumn {
            val displayedVacancies =
                if (showAllVacancies) uiState.vacancies else uiState.vacancies.take(3)

            items(displayedVacancies) { vacancy ->
                VacancyItem(
                    vacancy = vacancy,
                    onFavoriteClick = { viewModel.toggleFavorite(vacancy) }
                )
            }

            if (!showAllVacancies && uiState.vacancies.size > 3) {
                item {
                    ShowMoreButton(
                        remainingCount = uiState.vacancies.size - 3,
                        onClick = { showAllVacancies = true }
                    )
                }
            }
        }
    }
}