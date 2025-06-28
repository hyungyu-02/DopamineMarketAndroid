package com.myteam.hackathonapp.presentation.routines

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.myteam.hackathonapp.presentation.component.BottomNavigationBar
import com.myteam.hackathonapp.presentation.component.HackathonFAB
import com.myteam.hackathonapp.presentation.component.topappbar.HackathonTopAppBar
import com.myteam.hackathonapp.presentation.routines.component.LazyRoutineComponent


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
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF6F6F9)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 17.dp)
        ){
            LazyRoutineComponent(
                modifier = Modifier
                    .padding(top = 24.dp),
                name = "고정루틴"
            )
            LazyRoutineComponent(
                modifier = Modifier
                    .padding(top = 26.dp),
                name = "오늘의 루틴"
            )
        }
    }
}

@Preview
@Composable
private fun DiaryScreenPreview() {
    RoutineScreenContent()
}