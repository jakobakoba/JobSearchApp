package com.bor96dev.presentation.composables

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.bor96dev.domain.Recommendation
import com.bor96dev.presentation.R
import com.bor96dev.presentation.ui.theme.Green
import com.bor96dev.presentation.ui.theme.White

@Composable
fun RecommendationItem(
    recommendation: Recommendation,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .width(132.dp)
            .height(140.dp)
            .padding(start = 4.dp, end = 4.dp)
            .clickable{
                val intent = Intent(Intent.ACTION_VIEW, recommendation.link.toUri())
                context.startActivity(intent)
            }
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            recommendation.id?.let {id ->
                val iconRes = getRecommendationIcon(id)
                Image (
                    painter = painterResource(iconRes),
                    contentDescription = null,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = recommendation.title,
                color = White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 16.sp,
                maxLines = if(recommendation.button != null) 2 else 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
            recommendation.button?.let {buttonText ->
                Text(
                    text = buttonText,
                    fontSize = 14.sp,
                    color = Green
                )
            }
        }
    }
}

private fun getRecommendationIcon(id: String): Int {
    return when(id){
        "near_vacancies" -> R.drawable.near
        "level_up_resume" -> R.drawable.levelup
        else -> R.drawable.temporaryjob
    }
}