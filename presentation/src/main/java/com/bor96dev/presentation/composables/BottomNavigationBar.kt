package com.bor96dev.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bor96dev.presentation.MainViewModel
import com.bor96dev.presentation.R
import com.bor96dev.presentation.navigation.Destinations
import com.bor96dev.presentation.ui.theme.White

@Composable
fun BottomNavigationBar(
    navController: NavController,
    viewModel: MainViewModel
    ) {
    val uiState by viewModel.uiState.collectAsState()
    val favoriteCount = uiState.vacancies.count{it.isFavorite}
    val items = listOf(
        Destinations.Search,
        Destinations.Favorites,
        Destinations.Responses,
        Destinations.Messages,
        Destinations.Profile
    )

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    NavigationBar {
        items.forEach { destination ->
            NavigationBarItem(
                selected = currentRoute == destination.route,
                onClick = {
                    navController.navigate(destination.route) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    Box{
                        Icon(
                            painter = painterResource(id = findIcon(destination)),
                            contentDescription = destination.route
                        )
                        if (destination == Destinations.Favorites && favoriteCount > 0){
                            Box (
                                modifier = Modifier
                                    .size(16.dp)
                                    .offset(x = 2.dp, y = (-2).dp)
                                    .align(Alignment.TopEnd),
                                contentAlignment = Alignment.TopCenter
                            ) {
                                Image (
                                    painter = painterResource(id = R.drawable.red_dot),
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = favoriteCount.toString(),
                                    fontSize = 8.sp,
                                    color = White,
                                    modifier = Modifier.offset(y = (-5).dp)
                                )
                            }
                        }
                    }

                },
                label = {
                    Text(
                        text = findLabel(destination),
                        fontSize = 10.sp,
                    )
                }
            )
        }
    }
}

private fun findIcon(destination: Destinations): Int {
    return when (destination) {
        Destinations.Search -> R.drawable.search_ic
        Destinations.Favorites -> R.drawable.favorite_unchecked_ic
        Destinations.Responses -> R.drawable.responses_ic
        Destinations.Messages -> R.drawable.messages_ic
        Destinations.Profile -> R.drawable.profile_ic
        Destinations.VacancyDetail -> R.drawable.profile_ic
    }
}

private fun findLabel(destination: Destinations): String {
    return when (destination) {
        Destinations.Search -> "Поиск"
        Destinations.Favorites -> "Избранное"
        Destinations.Responses -> "Отклики"
        Destinations.Messages -> "Сообщения"
        Destinations.Profile -> "Профиль"
        Destinations.VacancyDetail -> ""
    }
}