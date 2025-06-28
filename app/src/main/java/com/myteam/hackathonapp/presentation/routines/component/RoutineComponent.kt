package com.myteam.hackathonapp.presentation.routines.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myteam.hackathonapp.data.dto.response.RoutineItemDto

@Composable
fun RoutineComponent(
    routine: RoutineItemDto,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(13.dp))
            .shadow(1.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFDBEAFE)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = routine.category, color = Color.White)
                }

                Column(modifier = Modifier.padding(start = 13.dp)) {
                    Text(text = routine.title, fontSize = 13.sp, fontWeight = FontWeight(700))
                    Text(
                        text = "${routine.timer}min • ${routine.category}",
                        fontSize = 11.sp,
                        color = Color(0x80000000)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .size(49.dp, 36.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFF3B73ED))
                    .clickable {
                        // Start 버튼 클릭 시 할 일 (예: 완료 API 호출)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Start", fontSize = 12.sp, color = Color.White)
            }
        }
    }
}