package com.myteam.hackathonapp.presentation.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController

@Composable
fun AuthCheckScreen(
    navController: NavController
) {
    val currentUser = null

    LaunchedEffect(Unit) {
        if (currentUser != null) {
            // 로그인된 상태 → 홈 화면으로 이동
            navController.navigate("apps") {
                popUpTo("authCheck") { inclusive = true }
            }
        } else {
            // 로그인 안 된 상태 → 로그인 화면으로 이동
            navController.navigate("login") {
                popUpTo("authCheck") { inclusive = true }
            }
        }
    }
}