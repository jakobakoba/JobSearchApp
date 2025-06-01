package com.bor96dev.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bor96dev.presentation.R
import com.bor96dev.presentation.ui.theme.Blue
import com.bor96dev.presentation.ui.theme.Grey2

@Composable
fun SearchHeaderExpanded(
    vacanciesCount: Int,
    onBackClick: () -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(IntrinsicSize.Min)
        ) {
            TextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(
                        "Должность по подходящим вакан...",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.back_ic),
                        contentDescription = "Назад",
                        modifier = Modifier.clickable { onBackClick() }
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Grey2, shape = RoundedCornerShape(16.dp))
            ) {
                Icon(
                    painterResource(id = R.drawable.filter),
                    contentDescription = "Фильтр"
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,) {
            Text(
                text = "${vacanciesCount} ${getVacancyWord(vacanciesCount)}",
                modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Blue
                ),
                elevation = null
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