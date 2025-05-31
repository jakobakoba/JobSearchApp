package com.bor96dev.presentation

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

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Search.route,
        modifier = modifier
    ) {
        composable(Destinations. Search.route){
            SearchScreen()
        }
        composable(Destinations.Favorites.route){
            FavoriteScreen()
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