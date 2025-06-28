package com.myteam.hackathonapp.core.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun HackathonTitle(modifier: Modifier = Modifier, title: String) {
    Text(
        text = title,
        fontSize = 20.sp
    )
}