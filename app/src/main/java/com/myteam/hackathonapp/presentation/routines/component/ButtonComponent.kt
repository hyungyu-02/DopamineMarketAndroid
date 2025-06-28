package com.myteam.hackathonapp.presentation.routines.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    buttonText: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .size(60.dp, 32.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(if (isSelected) Color(0xFFEFF6FF) else Color(0xFFFFFFFF))
            .border(0.5.dp, if(isSelected) Color(0xFF3B73ED) else Color(0xFFCACACA), shape = RoundedCornerShape(6.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = buttonText,
            fontSize = 12.sp,
            fontWeight = FontWeight(350),
            color = Color(0xFF000000)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ButtonComponentPreview(modifier: Modifier = Modifier) {
    ButtonComponent(buttonText = "hello", isSelected = false, onClick = {})
}