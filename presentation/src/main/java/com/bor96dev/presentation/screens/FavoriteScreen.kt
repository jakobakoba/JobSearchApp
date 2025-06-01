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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bor96dev.presentation.MainViewModel
import com.bor96dev.presentation.composables.VacancyItem
import com.bor96dev.presentation.composables.getVacancyWord
import com.bor96dev.presentation.ui.theme.White


@Composable
fun FavoriteScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onVacancyClick: (String) -> Unit = {}
) {

    val uiState by viewModel.uiState.collectAsState()
    val favoriteVacancies = uiState.vacancies.filter { it.isFavorite }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ){
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Избранное",
            fontSize = 20.sp,
            color = White,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "${favoriteVacancies.size} ${getVacancyWord(favoriteVacancies.size)}",
            fontSize = 14.sp,
            color = White
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(favoriteVacancies) { vacancy ->
                VacancyItem(
                    vacancy = vacancy,
                    onFavoriteClick = { viewModel.toggleFavorite(vacancy) },
                    onVacancyClick = onVacancyClick
                )
            }
        }
    }
}