package com.myteam.hackathonapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.myteam.hackathonapp.presentation.apps.AppsScreen
import com.myteam.hackathonapp.presentation.login.AuthCheckScreen
import com.myteam.hackathonapp.presentation.login.LoginScreen
import com.myteam.hackathonapp.presentation.routines.RoutinesScreen

@Composable
fun HackathonNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Route.AuthCheck.route
    ) {

        composable(route = Route.AuthCheck.route) {
            AuthCheckScreen(navController = navController)
        }
        composable(route = Route.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Route.Apps.route) {
                        popUpTo(Route.Login.route) { inclusive = true }
                    }
                }
            )
        }

        composable(route = Route.Apps.route) {
            AppsScreen(navController = navController)
        }

        composable(route = Route.Routines.route) {
            RoutinesScreen(navController = navController)
        }
//
//        composable(route = Route.My.route) {
//            MyScreen(modifier = modifier)
//        }
    }
}