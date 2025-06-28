package com.myteam.hackathonapp.presentation.routines.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.myteam.hackathonapp.ui.theme.DopamineMarketTheme.colors

@Composable
fun AddRoutineComponent(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit
    ) {
    var button_type = "데일리"
    var time by remember { mutableStateOf("") }
    var routine_name by remember { mutableStateOf("") }
    var emoji by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf<String?>(null) }
    var selectedCategory2 by remember { mutableStateOf<String?>(null) }
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(13.dp),
            tonalElevation = 8.dp
        ) {
            Box(
                modifier = Modifier
                    .size(310.dp, 350.dp)
                    .clip(RoundedCornerShape(13.dp))
                    .background(color = colors.White)
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
                                .background(color = colors.Sub_Blue),
                            contentAlignment = Alignment.Center
                        ) {
                            OutlinedTextField(
                                value = emoji,
                                onValueChange = { emoji = it },
                                placeholder = {
                                    Text(
                                        text = "\uD83C\uDF31"
                                    )
                                },
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = colors.Sub_Blue,
                                    disabledContainerColor = colors.Sub_Blue,
                                    unfocusedContainerColor = colors.Sub_Blue,
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
                            onValueChange = { routine_name = it },
                            modifier = Modifier
                                .width(194.dp)
                                .padding(top = 8.dp, bottom = 8.dp)
                                .clip(RoundedCornerShape(7.dp))
                                .border(
                                    0.5.dp,
                                    color = colors.Box_Grey,
                                    shape = RoundedCornerShape(7.dp)
                                ),
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
                        modifier = Modifier
                            .padding(top = 1.dp),
                        text = "카테고리",
                        fontSize = 12.sp,
                        fontWeight = FontWeight(600)
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 3.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        listOf("운동", "일상", "학습", "식단").forEach { category ->
                            ButtonComponent(
                                buttonText = category,
                                isSelected = selectedCategory == category,
                                onClick = {
                                    selectedCategory = category
                                }
                            )
                        }}
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
                            listOf("없음", "10분", "20분").forEach { category ->
                                ButtonComponent(
                                    buttonText = category,
                                    isSelected = selectedCategory2 == category,
                                    onClick = {
                                        selectedCategory2 = category
                                    }
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .size(60.dp, 32.dp)
                                    .clickable(
                                        onClick = {

                                        }
                                    )
                                    .clip(RoundedCornerShape(6.dp))
                                    .border(
                                        0.5.dp,
                                        color = Color(0xFFCACACA),
                                        shape = RoundedCornerShape(6.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                BasicTextField(
                                    value = time,
                                    onValueChange = { time = it },
                                    singleLine = true,
                                    modifier = Modifier.fillMaxSize(),
                                    textStyle = TextStyle(
                                        fontSize = 12.sp,
                                        textAlign = TextAlign.Center,
                                        lineHeight = 32.sp
                                    ),
                                    decorationBox = { innerTextField ->
                                        if (time.isEmpty()) {
                                            Box(
                                                modifier = Modifier,
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(
                                                    text = "직접 입력",
                                                    color = colors.Box_Grey,
                                                    fontSize = 12.sp,
                                                    textAlign = TextAlign.Center
                                                )
                                            }
                                        }
                                        innerTextField()
                                    }
                                )
                            }
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
                                    .background(color = colors.Main_Blue)
                                    .clickable(
                                        onClick = {

                                        }
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
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
                                    .border(
                                        0.5.dp,
                                        color = Color(0xFFCACACA),
                                        shape = RoundedCornerShape(7.dp)
                                    )
                                    .clickable(
                                        onClick = {
                                            onDismiss()
                                        }
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
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