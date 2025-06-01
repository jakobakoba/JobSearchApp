package com.bor96dev.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bor96dev.domain.Vacancy
import com.bor96dev.presentation.R

@Composable
fun VacancyItem(
    vacancy: Vacancy,
    onFavoriteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                vacancy.lookingNumber?.let { lookingNumber ->
                    Text(
                        text = "Сейчас просматривают: $lookingNumber ${getPersonWord(lookingNumber)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.secondary
                    )

                    IconButton(onClick = onFavoriteClick) {
                        Icon(
                            painter = painterResource(
                                if (vacancy.isFavorite) R.drawable.favorite_checked else R.drawable.favorite_unchecked_ic
                            ),
                            contentDescription = "Избранное"
                        )
                    }
                }

                Text(vacancy.title)
                Text(vacancy.address.town)
                Row() {
                    Text(vacancy.company)
                    Icon(
                        painter = painterResource(R.drawable.checked),
                        contentDescription = "Компания"
                    )
                }
                Row() {
                    Icon(
                        painter = painterResource(R.drawable.experience),
                        contentDescription = "Опыт"
                    )
                    Text(vacancy.experience.previewText)
                }
                Text(vacancy.publishedDate)
            }
        }
    }
}