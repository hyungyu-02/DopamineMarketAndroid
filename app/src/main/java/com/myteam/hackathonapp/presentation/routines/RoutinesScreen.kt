package com.myteam.hackathonapp.presentation.routines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.myteam.hackathonapp.core.component.HackathonTitle
import com.myteam.hackathonapp.presentation.component.HackathonFAB
import com.myteam.hackathonapp.presentation.component.HackathonTopAppBar

@Composable
fun RoutinesScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            HackathonTopAppBar()
        },
        floatingActionButton = {
            HackathonFAB {  }
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HackathonTitle(title = "Routines Screen")
        }
    }
}

@Preview
@Composable
private fun DiaryScreenPreview() {
    RoutinesScreen()
}