package com.myteam.hackathonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.myteam.hackathonapp.presentation.component.BottomNavigationBar
import com.myteam.hackathonapp.presentation.navigation.HackathonNavGraph
import com.myteam.hackathonapp.presentation.navigation.Route
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
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute by remember(navBackStackEntry) {
                    derivedStateOf {
                        Route.getRoute(navBackStackEntry?.destination?.route)
                    }
                }

                Scaffold(
                    bottomBar = {
                        if (currentRoute.isRoot){
                            BottomNavigationBar(navController)
                        }
                    }
                ) { innerPadding ->
                    HackathonNavGraph(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}