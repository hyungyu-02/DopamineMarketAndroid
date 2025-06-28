package com.myteam.hackathonapp.presentation.component.topappbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myteam.hackathonapp.R


@Composable
fun ProfileComponent(
    username: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(
                color = Color(0xB0EFF6FF),
                shape = RoundedCornerShape(15.dp)
            )
            .padding(end = 16.dp)
    ) {
        // 원형 아이콘 (drawable 사용)
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "User",
            tint = Color.Blue,
            modifier = Modifier
                .size(40.dp)
                .paint(
                    painter = painterResource(R.drawable.profile_icon),
                    contentScale = ContentScale.FillBounds
                )
                .padding(10.dp)
        )

        Spacer(modifier = Modifier.width(15.dp))

        Text(
            text = username,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileComponent() {
    ProfileComponent(
        username = "User 10"
    )
}