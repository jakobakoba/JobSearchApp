package com.bor96dev.presentation.composables

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bor96dev.presentation.R
import com.bor96dev.presentation.navigation.Destinations

@Composable
fun BottomNavigationBar(navController: NavController) {

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
                    Icon(
                        painter = painterResource(id = findIcon(destination)),
                        contentDescription = destination.route
                    )
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