package org.example.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.movies.presentation.screen.MoviesScreen
import org.example.project.profile.presentation.screen.ProfileScreen
import org.example.project.signin.presentation.screen.LoginScreen
import org.example.project.earthquakes.presentation.screen.EarthquakeScreen
@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoute.Earthquakes
    ) {

        composable<NavRoute.Login> {
            LoginScreen(
                navController = navController
            )
        }

        composable<NavRoute.Movies> {
            MoviesScreen()
        }

        composable<NavRoute.Profile> {
            ProfileScreen()
        }

        composable<NavRoute.Earthquakes> {
            EarthquakeScreen()
        }
    }
}