package com.myteam.hackathonapp.presentation.routines

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.myteam.hackathonapp.core.component.HackathonTitle
import com.myteam.hackathonapp.presentation.component.BottomNavigationBar
import com.myteam.hackathonapp.presentation.component.HackathonFAB
import com.myteam.hackathonapp.presentation.component.HackathonTopAppBar
import com.myteam.hackathonapp.presentation.routines.component.LazyRoutineComponent
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
            .fillMaxHeight()
            .padding(horizontal = 17.dp)
    ){
        LazyRoutineComponent(
            modifier = Modifier
                .padding(top = 81.dp),
            name = "오늘의 루틴"
        )
        LazyRoutineComponent(
            modifier = Modifier
                .padding(top = 26.dp),
            name = "고정루틴"
        )
    }
}

@Preview
@Composable
private fun DiaryScreenPreview() {
    RoutineScreenContent()
}