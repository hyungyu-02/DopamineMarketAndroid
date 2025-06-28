package com.myteam.hackathonapp.presentation.apps

import android.util.Log
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
import com.myteam.hackathonapp.data.local.UserSession
import com.myteam.hackathonapp.domain.entity.AppsModel
import com.myteam.hackathonapp.presentation.apps.component.AddAppDialog
import com.myteam.hackathonapp.presentation.apps.component.AddAppRectangle
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
    val userId = UserSession.userId?.toInt()

    LaunchedEffect(Unit) {
        if(userId != null){
            viewModel.getAppsData(userId = userId)
        }
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
                .consumeWindowInsets(innerPadding),
            apps = viewModel.apps,
            onAddAppClick = { showModal = true }
        )
    }

    if (showModal) {
        AddAppDialog(
            onDismiss = { showModal = false }
        )
    }
}

@Composable
fun AppsScreenContent(
    modifier: Modifier = Modifier,
    apps: List<AppsModel>, // 🔥 AppsModel 리스트 받음
    onAddAppClick: () -> Unit
) {
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
        ) {
            items(apps) { app ->
                AppRectangle(
                    appName = app.appName,
                    isSelected = app.isLocked, // 🔥 서버에서 isLocked 여부로 선택 상태
                    onClick = {
                        Log.d("AppsScreen", "${app.appName} 클릭됨 - 잠금 상태: ${!app.isLocked}")
                        // 앱 선택 토글 로직은 서버에서 관리된다면 생략하거나 Dialog를 띄우는 정도만 처리
                    },
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxSize()
                )
            }

            item {
                AddAppRectangle(
                    onClick = {
                        Log.d("AppsScreen", "앱 추가 버튼 클릭됨")
                        onAddAppClick()
                    },
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxSize()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppsScreenPreview() {
    AppsScreenContent(
        apps = listOf(
            AppsModel(1, "YouTube", "https://youtube.com", coinRequired = 10, isLocked = false),
            AppsModel(2, "Instagram", "https://instagram.com", coinRequired = 15, isLocked = true),
        ),
        onAddAppClick = {}
    )
}