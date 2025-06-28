package com.myteam.hackathonapp.presentation.navigation

sealed class Route(
    val route: String,
    val isRoot: Boolean = true
) {
    data object Apps : Route(route = "apps")

    data object Routines : Route(route = "routines")

    data object Login : Route(route = "login", isRoot = false)

    data object AuthCheck : Route(route = "authCheck", isRoot = false)

    companion object {
        fun getRoute(route: String?): Route {
            return when (route) {
                Apps.route -> Apps
                Routines.route -> Routines
                Login.route -> Login
                AuthCheck.route -> AuthCheck
                else -> Apps // Default route if none matches
            }
        }
    }

    //data object My : Route(route = "my")
}