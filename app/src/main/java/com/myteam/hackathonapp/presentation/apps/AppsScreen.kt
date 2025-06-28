package com.myteam.hackathonapp.presentation.apps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.myteam.hackathonapp.presentation.apps.component.AddAppDialog
import com.myteam.hackathonapp.presentation.apps.component.AddAppRectangle
import com.myteam.hackathonapp.presentation.apps.component.AppItem
import com.myteam.hackathonapp.presentation.apps.component.AppRectangle
import com.myteam.hackathonapp.presentation.component.BottomNavigationBar
import com.myteam.hackathonapp.presentation.component.topappbar.HackathonTopAppBar
import com.myteam.hackathonapp.ui.theme.DopamineMarketTheme.colors
import com.myteam.hackathonapp.ui.theme.DopamineMarketTheme.typography

@Composable
fun AppsScreen(
    modifier: Modifier = Modifier,
    viewModel: AppsViewModel = hiltViewModel(),
    navController: NavHostController
) {
    var showModal by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        viewModel.getAppsData(1)
    }

    Scaffold(
        topBar = {
            HackathonTopAppBar(
                userName = "User10",
                coinAmount = 10
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        AppsScreenContent(
            modifier = modifier
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding)
        )
    }
    if(showModal){
        AddAppDialog(
            onDismiss = {showModal = false}
        )
    }
}

@Composable
fun AppsScreenContent( // 프리뷰용 Composable
    modifier: Modifier = Modifier
) {
    var showModal by remember { mutableStateOf(false) }
    var showAddDialog by remember { mutableStateOf(false) }
    var apps by remember {
        mutableStateOf(
            listOf(
                AppItem("YouTube"),
                AppItem("Instagram", true),
                AppItem("Netflix"),
                AppItem("TikTok"),
                AppItem("Twitter")
            )
        )
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colors.Background_Grey)
            .padding(top = 19.dp)
            .padding(horizontal = 26.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "제한된 앱 목록",
            style = typography.B_20,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.fillMaxWidth()
        ){
            items(apps) { app ->
                AppRectangle(
                    appName = app.name,
                    isSelected = app.isSelected,
                    onClick = {
                        apps = apps.map {
                            if (it.name == app.name) it.copy(isSelected = !it.isSelected)
                            else it
                        }
                    },
                    modifier = Modifier
                        .aspectRatio(1f) // 정사각형 비율 유지
                        .fillMaxSize() // 그리드 셀 내에서 최대 너비 사용
                )
            }
            item {
                AddAppRectangle(
                    onClick = { showModal = true },
                    modifier = Modifier
                        .aspectRatio(1f) // 정사각형 비율 유지
                        .fillMaxSize() // 그리드 셀 내에서 최대 너비 사용
                )
            }

        }
    }
    if(showModal){
        AddAppDialog(
            onDismiss = {showModal = false}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AppsScreenPreview() {
    AppsScreenContent()
}