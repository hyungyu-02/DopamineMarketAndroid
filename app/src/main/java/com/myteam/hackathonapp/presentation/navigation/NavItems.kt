package com.myteam.hackathonapp.presentation.navigation

import com.myteam.hackathonapp.R

object NavItems {
    val BarItems = listOf(
        BottomNavItem(
            label = "Apps",
            route = Route.Apps.route,
            icon = R.drawable.apps,
            selectedIcon = R.drawable.apps_selected
        ),
        BottomNavItem(
            label = "Routines",
            route = Route.Routines.route,
            icon = R.drawable.routines,
            selectedIcon = R.drawable.routines_selected
        ),
//        BottomNavItem(
//            label = "마이",
//            route = Route.My.route,
//            icon = R.drawable.ic_my,
//            selectedIcon = R.drawable.ic_my_selected
//        )
    )
}