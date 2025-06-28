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
            }
        }
    }
}