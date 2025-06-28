package com.myteam.hackathonapp.presentation.apps.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Composable
fun AddAppDialog(
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
                    //.size(310.dp)
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
                            focusedBorderColor = Color(0xFFDDDDDD),        // 연한 회색 테두리
                            unfocusedBorderColor = Color(0xFFDDDDDD),      // 연한 회색 테두리
                            focusedContainerColor = Color(0xFFFFFFFF),     // 완전한 흰색 배경
                            unfocusedContainerColor = Color(0xFFFFFFFF)    // 완전한 흰색 배경
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
                            .padding(bottom = 101.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFFDDDDDD),        // 연한 회색 테두리
                            unfocusedBorderColor = Color(0xFFDDDDDD),      // 연한 회색 테두리
                            focusedContainerColor = Color(0xFFFFFFFF),     // 완전한 흰색 배경
                            unfocusedContainerColor = Color(0xFFFFFFFF)    // 완전한 흰색 배경
                        ),
                        singleLine = true
                    )

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
                                .width(130.dp)
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
                                .width(130.dp)
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

@Preview(showBackground = true, widthDp = 400, heightDp = 1000)
@Composable
fun AddAppDialogPreview() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.4f)),
            contentAlignment = Alignment.Center
        ) {
            AddAppDialog(
                showDialog = true,
                onDismiss = {},
                onSave = { name, url ->
                    println("저장: $name, $url")
                }
            )
        }
    }
}
