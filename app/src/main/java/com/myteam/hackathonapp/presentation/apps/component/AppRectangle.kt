package com.myteam.hackathonapp.presentation.apps.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AppRectangle(
    appName: String,
    isSelected: Boolean = false,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(100.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(15.dp))
            .background(Color.White)
            .border(
                width = if (isSelected) 3.dp else 1.dp,
                color = if (isSelected) Color(0xFF4A90E2) else Color(0xFFE0E0E0),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClick() }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        // 텍스트로 앱 이름 표시
        Text(
            text = appName,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = if (isSelected) Color(0xFF4A90E2) else Color(0xFF333333),
            textAlign = TextAlign.Center,
            maxLines = 2
        )
    }
}

@Composable
fun AddAppRectangle(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(80.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF5F5F5))
            .border(
                width = 1.dp,
                color = Color(0xFFE0E0E0),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "+",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF999999)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppRectanglePreview() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp) // 프리뷰에 패딩 추가
    ) {
        AppRectangle(
            appName = "YouTube",
            isSelected = false,
            modifier = Modifier.width(80.dp) // 프리뷰용 고정 크기
        )
        AppRectangle(
            appName = "Instagram",
            isSelected = true,
            modifier = Modifier.width(80.dp) // 프리뷰용 고정 크기
        )
        AddAppRectangle(
            modifier = Modifier.width(80.dp) // 프리뷰용 고정 크기
        )
    }
}
