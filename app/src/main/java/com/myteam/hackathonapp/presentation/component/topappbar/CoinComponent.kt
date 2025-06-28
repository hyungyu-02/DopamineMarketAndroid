package com.myteam.hackathonapp.presentation.component.topappbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CoinComponent(
    coins: Int,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = "Coins:",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF000000)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Box(
            modifier = Modifier
                .size(34.dp) // 고정 크기
                .background(
                    Color(0xFF4A90E2),
                    CircleShape
                ),
            contentAlignment = Alignment.Center // 중앙 정렬 추가
        ) {
            Text(
                text = coins.toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                maxLines = 1, // 한 줄로 제한
                overflow = TextOverflow.Ellipsis // 넘치면 ... 표시
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CoinComponent() {
    CoinComponent(
        coins=10,
    )
}