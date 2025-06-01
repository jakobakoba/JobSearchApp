package com.bor96dev.presentation.composables

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.bor96dev.domain.Recommendation
import com.bor96dev.presentation.R

@Composable
fun RecommendationItem(
    recommendation: Recommendation,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{
                val intent = Intent(Intent.ACTION_VIEW, recommendation.link.toUri())
                context.startActivity(intent)
            }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            recommendation.id?.let {id ->
                val iconRes = getRecommendationIcon(id)
                Icon (
                    painter = painterResource(iconRes),
                    contentDescription = null,
                )
            }
            Text(
                text = recommendation.title,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = if(recommendation.button != null) 2 else 3,
                overflow = TextOverflow.Ellipsis
            )
            recommendation.button?.let {buttonText ->
                Text(
                    text = buttonText,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Green
                )
            }
        }
    }
}

private fun getRecommendationIcon(id: String): Int {
    return when(id){
        "near_vacancies" -> R.drawable.near
        "level_up_resume" -> R.drawable.levelup
        else  -> R.drawable.temporaryjob
    }
}