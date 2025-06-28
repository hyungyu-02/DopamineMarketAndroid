package com.myteam.hackathonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.myteam.hackathonapp.presentation.navigation.HackathonNavGraph
import com.myteam.hackathonapp.ui.theme.HackathonAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            HackathonAppTheme {
                val navController = rememberNavController()
                HackathonNavGraph(navController = navController)
//                val navBackStackEntry by navController.currentBackStackEntryAsState()
//                val currentRoute by remember(navBackStackEntry) {
//                    derivedStateOf {
//                        Route.getRoute(navBackStackEntry?.destination?.route)
//                    }
//                }

//                Scaffold(
//                    topBar = {
//                        if (currentRoute.isRoot) {
//                            HackathonTopAppBar(
//                                userName = "User10",
//                                coinAmount = 10
//                            )
//                        }
//                    },
//                    bottomBar = {
//                        if (currentRoute.isRoot) {
//                            BottomNavigationBar(navController)
//                        }
//                    },
//                    floatingActionButton = {
//                        if (currentRoute.isRoot) {
//                            HackathonFAB() {
//                                // Handle FAB click
//                            }
//                        }
//                    }
//                ) { innerPadding ->
//                    HackathonNavGraph(
//                        navController = navController,
//                        modifier = Modifier
//                            .padding(innerPadding)
//                            .consumeWindowInsets(innerPadding)
//                    )
//                }
            }
        }
    }
}