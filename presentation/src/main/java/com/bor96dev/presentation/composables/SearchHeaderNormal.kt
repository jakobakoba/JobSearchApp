package com.bor96dev.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bor96dev.domain.Recommendation
import com.bor96dev.presentation.R

@Composable
fun SearchHeaderNormal(recommendations: List<Recommendation>) {
    Column(
    ) {
        Row (
            modifier = Modifier
                .padding(16.dp)
                .height(IntrinsicSize.Min)
        ){
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Должность, ключевые слова") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.search_ic),
                        contentDescription = "Поиск"
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
                    .background(Color.DarkGray, shape = RoundedCornerShape(16.dp))
            ) {
                Icon(
                    painterResource(id = R.drawable.filter),
                    contentDescription = "Фильтр"
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow() {
            items(recommendations) { recommendation ->
                RecommendationItem(recommendation = recommendation)
            }
        }
    }
}