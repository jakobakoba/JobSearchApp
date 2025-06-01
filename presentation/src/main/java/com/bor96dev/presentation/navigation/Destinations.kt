package com.bor96dev.presentation.navigation

sealed class Destinations(val route: String) {

    object Search: Destinations("search")
    object Favorites: Destinations("favorites")
    object Responses: Destinations("responses")
    object Messages: Destinations("messages")
    object Profile: Destinations("profile")
    object VacancyDetail: Destinations("vacancy_detail/{vacancyId}") {
        fun createRoute(vacancyId: String) = "vacancy_detail/$vacancyId"
    }
}