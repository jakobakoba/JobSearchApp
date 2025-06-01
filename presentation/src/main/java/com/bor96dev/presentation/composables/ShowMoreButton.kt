package com.bor96dev.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShowMoreButton(
    remainingCount: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(start = 15.dp, end = 15.dp, bottom = 5.dp),
        shape = RoundedCornerShape(8.dp)
    ){
        Text("Еще $remainingCount ${getVacancyWord(remainingCount)}")
    }

}

fun getVacancyWord(count: Int): String {
    return when{
        count % 10 == 1 && count % 100 != 11 -> "вакансия"
        count % 10 in 2 .. 4 && count % 100 !in 12 .. 14 -> "вакансии"
        else -> "вакансий"
    }
}

fun getPersonWord(count: Int ): String {
    return when {
        count % 10 == 1 && count % 100 != 11 -> "человек"
        count % 10 in 2 .. 4 && count % 100 !in 12 .. 14 -> "человека"
        else -> "человек"
    }
}