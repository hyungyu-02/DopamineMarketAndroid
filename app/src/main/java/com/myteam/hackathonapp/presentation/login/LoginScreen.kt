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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.ImageDecoderDecoder
import com.myteam.hackathonapp.R
import com.myteam.hackathonapp.core.util.modifier.addFocusCleaner
import com.myteam.hackathonapp.ui.theme.DopamineMarketTheme.colors
import com.myteam.hackathonapp.ui.theme.DopamineMarketTheme.typography

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
            .background(color = colors.White)
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
                style = typography.B_32
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
                            style = typography.R_15,
                            color = colors.Under_Menu_Grey
                        )
                    }
                },
                textStyle = typography.R_16,
                modifier = Modifier
                    .width(209.dp)
                    .height(55.dp),
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colors.User_Lightblue,
                    unfocusedContainerColor = colors.User_Lightblue,
                    focusedBorderColor = colors.User_Lightblue,
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
                            style = typography.R_15,
                            color = colors.Under_Menu_Grey
                        )
                    }
                },
                modifier = Modifier
                    .width(209.dp)
                    .height(55.dp),
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colors.User_Lightblue,
                    unfocusedContainerColor = colors.User_Lightblue,
                    focusedBorderColor = colors.User_Lightblue,
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
                    .background(color = colors.Main_Blue, shape = RoundedCornerShape(size = 20.dp))
                    .clickable {
                        onLoginSuccess()
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "입장하기",
                    style = typography.SB_18,
                    color =  colors.White
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