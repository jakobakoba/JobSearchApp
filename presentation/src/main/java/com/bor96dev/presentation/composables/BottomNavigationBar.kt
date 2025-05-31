package com.bor96dev.presentation.composables

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
                icon = { findIcon(destination) },
                label = { findLabel(destination) }
            )
        }
    }
}

private fun findIcon(destination: Destinations): Int {
    return when (destination) {
        Destinations.Search -> R.drawable.search_ic
        Destinations.Favorites -> R.drawable.favorite_unchecked_ic
        Destinations.Messages -> R.drawable.responses_ic
        Destinations.Profile -> R.drawable.messages_ic
        Destinations.Responses -> R.drawable.profile_ic
    }
}

private fun findLabel(destination: Destinations): String {
    return when (destination) {
        Destinations.Favorites -> "Поиск"
        Destinations.Messages -> "Избранное"
        Destinations.Profile -> "Отклики"
        Destinations.Responses -> "Сообщения"
        Destinations.Search -> "Профиль"
    }
}