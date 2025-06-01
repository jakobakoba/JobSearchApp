package com.bor96dev.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bor96dev.presentation.R

@Composable
fun SearchHeaderExpanded(
    vacanciesCount: Int,
    onBackClick: () -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = R.drawable.back_ic),
                    contentDescription = "Назад"
                )
            }

            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Должность по подходящим вакан...") }
            )

            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = "Фильтр"
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "${vacanciesCount} ${getVacancyWord(vacanciesCount)}",
                modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.width(16.dp))

            OutlinedButton(
                onClick = {},
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text("По соответствию")
                Icon(
                    painter = painterResource(id = R.drawable.arrows),
                    contentDescription = null
                )
            }
        }
    }
}