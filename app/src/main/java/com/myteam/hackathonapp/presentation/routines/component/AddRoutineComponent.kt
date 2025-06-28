package com.myteam.hackathonapp.presentation.routines.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.content.pm.ShortcutInfoCompat
import com.myteam.hackathonapp.presentation.apps.component.AddAppDialog

@Composable
fun AddRoutineComponent(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit
    ) {
    var button_type = "데일리"
    var routine_name by remember { mutableStateOf("") }
    var emoji by remember { mutableStateOf("") }
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(13.dp),
            tonalElevation = 8.dp
        ){
            Box(
                modifier = Modifier
                    .size(310.dp, 350.dp)
                    .clip(RoundedCornerShape(13.dp))
                    .background(color = Color(0xFFFFFFFF))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(13.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .clip(RoundedCornerShape(30.dp))
                                .background(color = Color(0xFFDBEAFE)),
                            contentAlignment = Alignment.Center
                        ) {
                            OutlinedTextField(
                                value = emoji,
                                onValueChange = {emoji = it},
                                placeholder = {
                                    Text(
                                        text = "\uD83C\uDF31"
                                    )
                                },
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color(0xFFDBEAFE),
                                    disabledContainerColor = Color(0xFFDBEAFE),
                                    unfocusedContainerColor = Color(0xFFDBEAFE),
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    disabledIndicatorColor = Color.Transparent,
                                    errorIndicatorColor = Color.Transparent
                                ),
                                singleLine = true
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = routine_name,
                            onValueChange = {routine_name = it},
                            modifier = Modifier
                                .width(194.dp)
                                .padding(top = 8.dp, bottom = 8.dp)
                                .clip(RoundedCornerShape(7.dp))
                                .border(0.5.dp, color = Color(0xFFDCDDDE), shape = RoundedCornerShape(7.dp)),
                            placeholder = {
                                Text(
                                    text = "루틴 이름",
                                    fontSize = 13.sp,
                                    color = Color(0xFFCACACA)
                                )
                            },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color(0xFFFFFFFF),
                                disabledContainerColor = Color(0xFFFFFFFF),
                                unfocusedContainerColor = Color(0xFFFFFFFF),
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent,
                                errorIndicatorColor = Color.Transparent
                            ),
                            singleLine = true
                        )
                        AddRoutineButton()
                    }
                    Text(
                        text = "카테고리",
                        fontSize = 12.sp,
                        fontWeight = FontWeight(600)
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 3.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        ButtonComponent(buttonText = "운동")
                        ButtonComponent(buttonText = "일상")
                        ButtonComponent(buttonText = "학습")
                        ButtonComponent(buttonText = "식단")
                    }
                    Text(
                        modifier = Modifier
                            .padding(top = 10.dp),
                        text = "카테고리",
                        fontSize = 12.sp,
                        fontWeight = FontWeight(600)
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        ButtonComponent(buttonText = "없음")
                        ButtonComponent(buttonText = "10분")
                        ButtonComponent(buttonText = "25분")
                        ButtonComponent(buttonText = "직접 입력")
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, bottom = 3.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(130.dp, 40.dp)
                                .clip(RoundedCornerShape(7.dp))
                                .background(color = Color(0xFF3B82F6))
                                .clickable(
                                    onClick = {

                                    }
                                ),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "저장하기",
                                fontSize = 11.sp,
                                fontWeight = FontWeight(600),
                                color = Color(0xFFFFFFFF)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(130.dp, 40.dp)
                                .clip(RoundedCornerShape(7.dp))
                                .background(color = Color(0xFFFFFFFF))
                                .border(0.5.dp, color = Color(0xFFCACACA), shape = RoundedCornerShape(7.dp))
                                .clickable(
                                    onClick = {
                                        onDismiss()
                                    }
                                ),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "취소",
                                fontSize = 11.sp,
                                fontWeight = FontWeight(600)
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
private fun AddRoutineComponentPreview(modifier: Modifier = Modifier) {
    var showModal by remember { mutableStateOf(false) }
    AddRoutineComponent(onDismiss = {showModal = false})
}