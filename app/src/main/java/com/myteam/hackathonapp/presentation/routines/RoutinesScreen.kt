package com.myteam.hackathonapp.presentation.routines

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.myteam.hackathonapp.presentation.component.BottomNavigationBar
import com.myteam.hackathonapp.presentation.component.HackathonFAB
import com.myteam.hackathonapp.presentation.component.topappbar.HackathonTopAppBar
import com.myteam.hackathonapp.presentation.routines.component.AddRoutineComponent
import com.myteam.hackathonapp.presentation.routines.component.LazyRoutineComponent
import com.myteam.hackathonapp.presentation.routines.viewmodel.RoutineViewModel


@Composable
fun RoutinesScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    var showModal by remember { mutableStateOf(false) }
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
            HackathonFAB { showModal = true }
        }
    ) { innerPadding ->
        RoutineScreenContent(
            modifier = Modifier
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding)
        )
    }
    if(showModal){
        AddRoutineComponent(
            onDismiss = {showModal = false}
        )
    }
}

@Composable
fun RoutineScreenContent(
    modifier: Modifier = Modifier,
    viewModel: RoutineViewModel = hiltViewModel(),
    userId: Int = 1
) {
    LaunchedEffect(Unit) {
        viewModel.loadRoutines(userId)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFF6F6F9))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 17.dp)
        ) {
            LazyRoutineComponent(
                modifier = Modifier.padding(top = 81.dp),
                name = "고정루틴",
                routines = viewModel.fixedRoutines,
                onDeleteRoutine = { routineId ->
                    viewModel.deleteRoutine(
                        userId = userId,
                        routineId = routineId,
                        onSuccess = {},
                        onError = { msg -> Log.e("Delete", msg) }
                    )
                }
            )

            LazyRoutineComponent(
                modifier = Modifier.padding(top = 26.dp),
                name = "오늘의 루틴",
                routines = viewModel.todayRoutines,
                onDeleteRoutine = { routineId ->
                    viewModel.deleteRoutine(
                        userId = userId,
                        routineId = routineId,
                        onSuccess = {},
                        onError = { msg -> Log.e("Delete", msg) }
                    )
                }
            )
        }
    }
}