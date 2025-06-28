package com.myteam.hackathonapp.presentation.apps.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.myteam.hackathonapp.data.dto.request.RegisterAppRequestDto
import com.myteam.hackathonapp.data.local.UserSession
import com.myteam.hackathonapp.presentation.apps.AppsViewModel


@Composable
fun AddAppDialog(
    onDismiss: () -> Unit,
    viewModel: AppsViewModel = hiltViewModel(),
    //onSave: (String, String) -> Unit
) {
    val userId = UserSession.userId ?: return
    var appName by remember { mutableStateOf("") }
    var appUrl by remember { mutableStateOf("") }
    Dialog(
        onDismissRequest = onDismiss,
    ) {
        Surface(
            shape = RoundedCornerShape(13.dp),
            tonalElevation = 8.dp
        ){
            Box(
                modifier = Modifier
                    .size(310.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color(0xFFFFFFFF)),
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
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
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
                            .padding(bottom = 50.dp),
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
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 0.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // 저장하기 버튼 (파란색)
                        Box(
                            modifier = Modifier
                                .clickable(
                                    onClick = {
                                        viewModel.registerApp(
                                            RegisterAppRequestDto(
                                                userId = userId,
                                                appName = "YouTube",
                                                url = "https://www.youtube.com/"
                                            )
                                        )
                                    }
                                )
                                .width(130.dp)
                                .height(40.dp)
                                .clip(RoundedCornerShape(7.dp))
                                .background(color = Color(0xFF3B73ED)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "저장하기",
                                color = Color(0xFFFFFFFF),
                                fontSize = 11.sp,
                                fontWeight = FontWeight(600),
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clickable(
                                    onClick = {
                                        onDismiss()
                                    }
                                )
                                .width(130.dp)
                                .height(40.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(color = Color(0xFFFFFFFF))
                                .border(width = 0.5.dp, color = Color(0xFFCACACA) ,shape = RoundedCornerShape(size = 7.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "취소",
                                fontSize = 11.sp,
                                fontWeight = FontWeight(600),
                                color = Color(0xFF000000)
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
                onDismiss = {},
                viewModel = TODO()
            )
        }
    }}
