package com.myteam.hackathonapp.presentation.routines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.myteam.hackathonapp.core.component.HackathonTitle

@Composable
fun RoutinesScreen(modifier: Modifier = Modifier) {
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
    RoutinesScreen()
}