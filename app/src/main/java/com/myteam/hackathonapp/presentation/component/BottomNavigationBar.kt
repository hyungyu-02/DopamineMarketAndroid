package com.myteam.hackathonapp.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.myteam.hackathonapp.presentation.navigation.NavItems
import com.myteam.hackathonapp.presentation.navigation.Route
import com.myteam.hackathonapp.ui.theme.DopamineMarketTheme.colors

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        containerColor = Color.White,     // ⬅️ 배경색
        tonalElevation = 0.dp                   //   (Material 오버레이 제거)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        NavItems.BarItems.forEach { item ->
            NavigationBarItem(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(Route.Apps.route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }

                    }
                },
                label = {
                    Text(
                        item.label,
                        color = if (currentRoute == item.route) colors.Main_Blue else colors.Under_Menu_Grey,
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                ),
                icon = {
                    Icon(
                        painter = painterResource(id = if (currentRoute == item.route) item.selectedIcon else item.icon),
                        contentDescription = item.label,
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(23.dp)
                    )
                }
            )
        }
    }
}