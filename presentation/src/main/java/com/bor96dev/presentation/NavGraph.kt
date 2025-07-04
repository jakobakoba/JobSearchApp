package com.bor96dev.presentation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bor96dev.presentation.navigation.Destinations
import com.bor96dev.presentation.screens.FavoriteScreen
import com.bor96dev.presentation.screens.MessageScreen
import com.bor96dev.presentation.screens.ProfileScreen
import com.bor96dev.presentation.screens.ResponseScreen
import com.bor96dev.presentation.screens.SearchScreen
import com.bor96dev.presentation.screens.VacancyDetailScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Search.route,
        modifier = modifier,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable(Destinations. Search.route){
            SearchScreen(
                viewModel = viewModel,
                onVacancyClick = {vacancyId ->
                    navController.navigate(Destinations.VacancyDetail.createRoute(vacancyId))
                }
            )
        }
        composable(Destinations.VacancyDetail.route){backStackEntry ->
            val vacancyId = backStackEntry.arguments?.getString("vacancyId") ?: ""
            VacancyDetailScreen(vacancyId = vacancyId)
        }
        composable(Destinations.Favorites.route){
            FavoriteScreen(viewModel = viewModel,
                onVacancyClick = {vacancyId ->
                    navController.navigate(Destinations.VacancyDetail.createRoute(vacancyId))
                })
        }
        composable(Destinations.Responses.route){
            ResponseScreen()
        }
        composable(Destinations.Messages.route){
            MessageScreen()
        }
        composable(Destinations.Profile.route){
            ProfileScreen()
        }
    }
}