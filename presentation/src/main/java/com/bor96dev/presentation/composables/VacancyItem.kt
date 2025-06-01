package com.bor96dev.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bor96dev.domain.Vacancy
import com.bor96dev.presentation.R
import com.bor96dev.presentation.ui.theme.Green
import com.bor96dev.presentation.ui.theme.Grey3
import com.bor96dev.presentation.ui.theme.White

@Composable
fun VacancyItem(
    vacancy: Vacancy,
    onFavoriteClick: () -> Unit,
    onVacancyClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable { onVacancyClick(vacancy.id) }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (vacancy.lookingNumber != null) {
                    Text(
                        text = "Сейчас просматривают: ${vacancy.lookingNumber} ${
                            getPersonWord(
                                vacancy.lookingNumber!!
                            )
                        }",
                        color = Green,
                        fontSize = 14.sp,
                        modifier = Modifier.weight(1f)
                    )
                } else {
                    Text(
                        text = vacancy.title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = White
                    )
                }

                IconButton(onClick = onFavoriteClick) {
                    Icon(
                        painter = painterResource(
                            if (vacancy.isFavorite) R.drawable.favorite_checked else R.drawable.favorite_unchecked_ic
                        ),
                        contentDescription = "Избранное"
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            if (vacancy.lookingNumber != null) {
                Text(
                    text = vacancy.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = White
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            Text(vacancy.address.town, color = White, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(vacancy.company, color = White, fontSize = 14.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(R.drawable.checked),
                    contentDescription = "Компания"
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.experience),
                    contentDescription = "Опыт"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(vacancy.experience.previewText, color = White, fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Опубликовано ${formatDate(vacancy.publishedDate)}", color = Grey3, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(21.dp))

            Button(
                onClick = {},
                modifier =Modifier
                    .fillMaxWidth()
                    .clickable(enabled = false) {},
                colors = ButtonDefaults.buttonColors(containerColor = Green),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text("Откликнуться", color = White, fontSize = 14.sp)
            }
        }
    }
}


private fun formatDate(dateString: String): String {
    val parts = dateString.split("-")
    val day = parts[2].toInt()
    val month = getMonth(parts[1].toInt())
    return "$day $month"
}

private fun getMonth(month: Int): String {
    return when (month){
        1 -> "января"
        2 -> "февраля"
        3 -> "марта"
        4 -> "апреля"
        5 -> "мая"
        6 -> "июня"
        7 -> "июля"
        8 -> "августа"
        9 -> "сентября"
        10 -> "октября"
        11 -> "ноября"
        else -> "декабря"
    }
}