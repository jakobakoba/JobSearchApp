package com.bor96dev.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bor96dev.presentation.MainViewModel
import com.bor96dev.presentation.composables.SearchHeaderExpanded
import com.bor96dev.presentation.composables.SearchHeaderNormal
import com.bor96dev.presentation.composables.ShowMoreButton
import com.bor96dev.presentation.composables.VacancyItem

@Composable
fun SearchScreen(
    viewModel: MainViewModel,
    onVacancyClick: (String) -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()
    var showAllVacancies by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        if (showAllVacancies) {
            SearchHeaderExpanded(
                vacanciesCount = uiState.vacancies.size,
                onBackClick = { showAllVacancies = false }
            )
        } else {
            SearchHeaderNormal(recommendations = uiState.recommendations)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Вакансии для вас",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            val displayedVacancies =
                if (showAllVacancies) uiState.vacancies else uiState.vacancies.take(3)

            items(displayedVacancies) { vacancy ->
                VacancyItem(
                    vacancy = vacancy,
                    onFavoriteClick = { viewModel.toggleFavorite(vacancy) },
                    onVacancyClick = onVacancyClick
                )
            }

            if (!showAllVacancies && uiState.vacancies.size > 3) {
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                    ShowMoreButton(
                        remainingCount = uiState.vacancies.size - 3,
                        onClick = { showAllVacancies = true }
                    )
                }
            }
        }
    }
}