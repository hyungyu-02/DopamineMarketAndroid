package com.example.dopaminemarket.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Composable
fun AddAppDialogWarning(
    showDialog: Boolean = true,
    onDismiss: () -> Unit,
    onSave: (String, String) -> Unit
) {
    var appName by remember { mutableStateOf("") }
    var appUrl by remember { mutableStateOf("") }

    if (showDialog) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(21.dp)
                ) {
                    // 제목
                    Text(
                        text = "앱 추가하기",
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )

                    // 앱 이름 입력 필드
                    OutlinedTextField(
                        value = appName,
                        onValueChange = { appName = it },
                        placeholder = {
                            Text(
                                "앱 이름",
                                color = Color(0xFFA9A9A9),
                                fontSize = 13.sp
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 13.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFFDDDDDD),
                            unfocusedBorderColor = Color(0xFFDDDDDD),
                            focusedContainerColor = Color(0xFFFFFFFF),
                            unfocusedContainerColor = Color(0xFFFFFFFF)
                        ),
                        singleLine = true
                    )

                    // URL 입력 필드
                    OutlinedTextField(
                        value = appUrl,
                        onValueChange = { appUrl = it },
                        placeholder = {
                            Text(
                                "URL",
                                color = Color(0xFFA9A9A9),
                                fontSize = 13.sp
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp), // 아래쪽 패딩 조정
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFFDDDDDD),
                            unfocusedBorderColor = Color(0xFFDDDDDD),
                            focusedContainerColor = Color(0xFFFFFFFF),
                            unfocusedContainerColor = Color(0xFFFFFFFF)
                        ),
                        singleLine = true
                    )

                    // 경고 문구 (URL 필드 바로 아래로 이동)
                    Text(
                        text = "⚠\uFE0F 앱 링크 형식과 맞지 않습니다.",
                        fontSize = 13.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFDD4A4A)
                    )

                    // 입력 필드와 버튼 사이의 간격
                    Spacer(modifier = Modifier.height(76.dp))

                    // 버튼 섹션
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // 저장하기 버튼 (파란색)
                        Button(
                            onClick = {
                                if (appName.isNotBlank() && appUrl.isNotBlank()) {
                                    onSave(appName, appUrl)
                                }
                            },
                            modifier = Modifier
                                .weight(1f)
                                .height(40.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF4285F4)
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = "저장하기",
                                color = Color.White,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        // 취소 버튼 (회색)
                        Button(
                            onClick = onDismiss,
                            modifier = Modifier
                                .weight(1f)
                                .height(40.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFF0F0F0)
                            ),
                            shape = RoundedCornerShape(8.dp),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 0.dp
                            )
                        ) {
                            Text(
                                text = "취소",
                                color = Color(0xFF484848),
                                lineHeight = 16.sp,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Normal
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddAppDialogWarningPreview() {
    MaterialTheme {
        AddAppDialogWarning(
            showDialog = true,
            onDismiss = { },
            onSave = { _, _ ->
                // 프리뷰에서는 실제 동작하지 않음
            }
        )
    }
}