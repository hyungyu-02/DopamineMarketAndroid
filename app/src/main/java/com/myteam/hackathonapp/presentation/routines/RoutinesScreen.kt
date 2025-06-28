package com.myteam.hackathonapp.presentation.routines

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.myteam.hackathonapp.presentation.component.BottomNavigationBar
import com.myteam.hackathonapp.presentation.component.HackathonFAB
import com.myteam.hackathonapp.presentation.component.topappbar.HackathonTopAppBar
import com.myteam.hackathonapp.presentation.routines.component.RoutineComponent

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
            .fillMaxWidth()
            .padding(horizontal = 17.dp)
    ){
        val lazyState = rememberLazyListState()
        Text(
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    top = 22.dp,
                    bottom = 17.dp
                ),
            text = "오늘의 루틴"
        )
        LazyColumn(
            state = lazyState,
            contentPadding = PaddingValues(bottom = 8.dp)
        ) {
            items(6){
                RoutineComponent()
            }
        }
    }
}

@Preview
@Composable
private fun DiaryScreenPreview() {
    RoutineScreenContent()
}