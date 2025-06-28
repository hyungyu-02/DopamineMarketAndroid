package com.myteam.hackathonapp.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.ImageDecoderDecoder
import com.myteam.hackathonapp.R
import com.myteam.hackathonapp.core.util.modifier.addFocusCleaner

@Composable
fun LoginScreen(
    //navController: NavController,
    onLoginSuccess: () -> Unit
) {
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val idInteraction = remember { MutableInteractionSource() }
    val pwInteraction = remember { MutableInteractionSource() }
    val idFocused by idInteraction.collectIsFocusedAsState()
    val pwFocused by pwInteraction.collectIsFocusedAsState()

    val focusManager = LocalFocusManager.current

    val loader = rememberGifImageLoader()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .addFocusCleaner(focusManager),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // top section
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(85.dp))
            Text(
                text = "도파민 상점",
                style = TextStyle(
                    fontSize = 32.sp,
                    //fontFamily = FontFamily(Font(R.font.segoe_ui)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )
            AsyncImage(
                model = R.drawable.dopaminemarketlogogif,
                contentDescription = "도파민 상점 애니메이션 로고",
                imageLoader = loader, // ← 꼭 전달
                modifier = Modifier
                    .size(251.dp)
            )
        }

        // middle section
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            OutlinedTextField(
                value = id,
                onValueChange = { id = it },
                interactionSource = idInteraction,
                placeholder = {
                    if (!idFocused && id.isEmpty()) {
                        Text(
                            text = "ID",
                            style = TextStyle(
                                fontSize = 15.sp,
                                //fontFamily = FontFamily(Font(R.font.segoe_ui)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF9CA3AF),
                            )
                        )
                    }
                },
                textStyle = LocalTextStyle.current.copy( // 기본 텍스트 스타일 설정
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF111827),
                    lineHeight = 20.sp
                ),
                modifier = Modifier
                    .width(209.dp)
                    .height(55.dp),
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFEFF6FF),
                    unfocusedContainerColor = Color(0xFFEFF6FF),
                    focusedBorderColor = Color(0xFFEFF6FF),
                    unfocusedBorderColor = Color.Transparent,
//                    focusedLabelColor = Color(0xFF4A90E2),
//                    unfocusedLabelColor = Color(0xFF999999)
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Password 입력 필드
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                interactionSource = pwInteraction,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                placeholder = {
                    if (!pwFocused && password.isEmpty()) {
                        Text(
                            text = "Password",
                            style = TextStyle(
                                fontSize = 15.sp,
                                //fontFamily = FontFamily(Font(R.font.segoe_ui)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF9CA3AF),
                            )
                        )
                    }
                },
                modifier = Modifier
                    .width(209.dp)
                    .height(55.dp),
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFEFF6FF),
                    unfocusedContainerColor = Color(0xFFEFF6FF),
                    focusedBorderColor = Color(0xFFEFF6FF),
                    unfocusedBorderColor = Color.Transparent,
//                    focusedLabelColor = Color(0xFF4A90E2),
//                    unfocusedLabelColor = Color(0xFF999999)
                ),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(131.dp))
            Column(
                Modifier
                    .width(293.dp)
                    .height(52.dp)
                    .background(color = Color(0xFF3B73ED), shape = RoundedCornerShape(size = 20.dp))
                    .clickable {
                        onLoginSuccess()
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "로그인하기",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 16.sp,
                        //fontFamily = FontFamily(Font(R.font.segoe_ui)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                    )
                )
            }
            Spacer(modifier = Modifier.height(44.dp))
        }

    }
}

@Composable
fun rememberGifImageLoader(): ImageLoader {
    val context = LocalContext.current
    return remember {
        ImageLoader.Builder(context)
            .components { add(ImageDecoderDecoder.Factory()) } // API 28+
            .build()
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen() {}
}