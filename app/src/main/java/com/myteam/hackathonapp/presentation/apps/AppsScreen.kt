package com.myteam.hackathonapp.presentation.apps

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.myteam.hackathonapp.core.component.HackathonTitle

@Composable
fun AppsScreen(
    modifier: Modifier = Modifier,
    viewModel: AppsViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.getAppsData(1)
    }

    AppsScreenContent(modifier = modifier)
}

@Composable
fun AppsScreenContent( // 프리뷰용 Composable
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HackathonTitle(title = "Apps Screen")
        Text("Welcome to the Apps Screen!")
    }
}

@Preview(showBackground = true)
@Composable
private fun AppsScreenPreview() {
    AppsScreenContent()
}