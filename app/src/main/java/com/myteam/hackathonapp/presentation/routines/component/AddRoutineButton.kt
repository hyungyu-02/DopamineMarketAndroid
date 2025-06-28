package com.myteam.hackathonapp.presentation.routines.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddRoutineButton(
    modifier: Modifier = Modifier
) {
    var clicked by remember { mutableStateOf(false) }
    var button_name = if(clicked){
        "데일리"
    } else "고정"
    Box(
        modifier = Modifier
            .clickable(
                onClick = {
                    clicked = !clicked
                }
            )
            .size(61.dp, 41.dp)
            .clip(RoundedCornerShape(25.dp))
            .border(width = 0.5.dp, color = Color(0xFFCACACA), shape = RoundedCornerShape(size = 25.dp)),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = button_name,
            fontSize = 14.sp,
            fontWeight = FontWeight(600),
            color = if(clicked) Color(0xCC40C740) else Color(0xCCDD4A4A)
        )
    }
}