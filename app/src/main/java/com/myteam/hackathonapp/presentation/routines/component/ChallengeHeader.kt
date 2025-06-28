package com.myteam.hackathonapp.presentation.routines.component

// ChallengeHeader.kt

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myteam.hackathonapp.R

/**
 * 1. 아이콘과 제목을 표시하는 헤더 컴포넌트
 * @param title 표시할 제목
 * @param icon 표시할 아이콘 (Painter)
 * @param iconTint 아이콘 색상
 */
@Composable
fun ChallengeHeader(
    title: String,
    icon: Painter,
    iconTint: Color
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // 아이콘을 원형 배경으로 감싸기
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(64.dp) // 배경 크기
        ) {
            // 배경 원 (ellipse_182)
            Image(
                painter = painterResource(id = R.drawable.ellipse_182),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

            // 위에 올라갈 아이콘
            Icon(
                painter = icon,
                contentDescription = title,
                tint = iconTint,
                modifier = Modifier.size(32.dp) // 아이콘 크기 (배경보다 작게)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Divider(modifier = Modifier.width(220.dp).padding(vertical = 16.dp))
    }
}

