package com.myteam.hackathonapp.presentation.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteam.hackathonapp.R
import com.myteam.hackathonapp.ui.theme.DopamineMarketTheme.colors

@Composable
fun HackathonFAB(
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = onClick,
        shape = CircleShape, // ✅ 완전한 원형
        containerColor = colors.Under_Menu_Grey, // 파란색 배경
        contentColor = Color.White,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 0.dp,       // ✅ 그림자 제거
            pressedElevation = 0.dp,
            focusedElevation = 0.dp,
            hoveredElevation = 0.dp
        )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_plus),
            contentDescription = "Add",
            modifier = Modifier.size(16.dp)
        )
    }
}

@Preview
@Composable
private fun FABPreview() {
    HackathonFAB { }
}