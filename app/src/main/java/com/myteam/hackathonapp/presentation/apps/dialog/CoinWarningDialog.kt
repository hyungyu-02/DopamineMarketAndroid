package com.myteam.hackathonapp.presentation.apps.dialog

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun CoinWarning(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (showDialog) {
        Dialog(onDismissRequest = onDismiss) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 40.dp, horizontal = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "코인이 부족합니다!",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 40.dp)
                    )

                    Button(
                        onClick = onConfirm,
                        modifier = Modifier
                            .border(width = 0.5.dp, Color(0xFFCACACA))
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFFFFF)  // 연한 회색으로 변경
                        ),
                        shape = RoundedCornerShape(7.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 1.dp  // 미세한 그림자 추가
                        )
                    ) {
                        Text(
                            text = "확인",
                            color = Color(0xFF333333),  // 진한 회색 텍스트
                            fontSize = 11.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight(600)  // 약간 더 굵게
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CoinWarningDialogPreview() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            CoinWarning(
                showDialog = true,
                onDismiss = {},
                onConfirm = {}
            )
        }
    }
}
