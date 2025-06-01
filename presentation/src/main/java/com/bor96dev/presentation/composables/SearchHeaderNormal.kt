package com.bor96dev.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bor96dev.domain.Recommendation
import com.bor96dev.presentation.R

@Composable
fun SearchHeaderNormal(recommendations: List<Recommendation>) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Должность, ключевые слова") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search_ic),
                    contentDescription = "Поиск"
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow {
            items(recommendations) { recommendation ->
                RecommendationItem(recommendation = recommendation)
            }
        }
    }
}