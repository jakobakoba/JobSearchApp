package com.bor96dev.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bor96dev.presentation.navigation.Destinations

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Destinations.Search.route
    ) {
        composable(Destinations. Search.route){

        }
        composable(Destinations.Favorites.route){

        }
        composable(Destinations.Responses.route){

        }
        composable(Destinations.Messages.route){

        }
        composable(Destinations.Profile.route){

        }
    }
}