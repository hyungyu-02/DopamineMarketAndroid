package com.myteam.hackathonapp.presentation.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.myteam.hackathonapp.data.local.UserSession

@Composable
fun AuthCheckScreen(
    navController: NavController
) {
    val currentUser = UserSession.userId

    LaunchedEffect(Unit) {
        if (currentUser != null) {
            navController.navigate("apps") {
                popUpTo("authCheck") { inclusive = true }
            }
        } else {
            navController.navigate("login") {
                popUpTo("authCheck") { inclusive = true }
            }
        }
    }
}