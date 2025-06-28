package com.myteam.hackathonapp.presentation.component.topappbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HackathonTopAppBar(
    userName: String = "User10",
    coinAmount: Int = 10
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(56.dp)
            .background(Color(0xFFFFFFFF))
            .padding(start = 19.dp, end = 23.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 프로필 컴포넌트
        ProfileComponent(username = userName)

        // 코인 컴포넌트
        CoinComponent(coins = coinAmount)
    }
}

    @Preview(showBackground = true)
    @Composable
    private fun HackathonTopAppBarPreview() {
        HackathonTopAppBar(
            userName = "User10",
            coinAmount = 10
        )
    }