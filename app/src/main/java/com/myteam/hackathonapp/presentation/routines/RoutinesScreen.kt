package com.myteam.hackathonapp.presentation.routines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.myteam.hackathonapp.core.component.HackathonTitle
import com.myteam.hackathonapp.presentation.component.BottomNavigationBar
import com.myteam.hackathonapp.presentation.component.HackathonFAB
import com.myteam.hackathonapp.presentation.component.HackathonTopAppBar

@Composable
fun RoutinesScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    Scaffold(
        topBar = {
            HackathonTopAppBar(
                userName = "User10",
                coinAmount = 10
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        },
        floatingActionButton = {
            HackathonFAB { /* Routines 전용 FAB 액션 */ }
        }
    ) { innerPadding ->
        RoutineScreenContent(
            modifier = modifier
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding)
        )
    }
}

@Composable
fun RoutineScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        HackathonTitle(title = "Routines Screen")
    }
}

@Preview
@Composable
private fun DiaryScreenPreview() {
    RoutineScreenContent()
}