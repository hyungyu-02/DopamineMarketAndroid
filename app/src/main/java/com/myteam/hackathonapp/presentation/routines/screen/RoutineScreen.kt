package com.myteam.hackathonapp.presentation.routines

import RoutineTimer
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myteam.hackathonapp.R
import com.myteam.hackathonapp.presentation.routines.component.ChallengeHeader


data class Routine(
    val name: String,
    val iconRes: Int,
    val iconTint: Color,
    val duration: Long // 밀리초
)

@Composable
fun RoutineScreen(
    routine: Routine,
    onDone: () -> Unit,
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // 상단 헤더 (기존 ChallengeHeader 사용)
        ChallengeHeader(
            title = routine.name,
            icon = painterResource(id = routine.iconRes),
            iconTint = routine.iconTint
        )

        // 중앙 타이머 (기존 Timer 컴포넌트 로직 활용)
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.weight(1f)
        ) {
            RoutineTimer(
                totalTime = routine.duration,
                handleColor = Color(0xFF2196F3), // 파란색 핸들
                inactiveBarColor = Color(0xFFE3F2FD), // 연한 파란색 배경
                activeBarColor = Color(0xFF2196F3), // 파란색 진행바
                modifier = Modifier.size(280.dp),
                strokeWidth = 12.dp
            )
        }

        // 하단 버튼들
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Done 버튼
            Button(
                onClick = onDone,
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Done",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }

            // 취소 버튼
            OutlinedButton(
                onClick = onCancel,
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "취소",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
            }
        }
    }
}
