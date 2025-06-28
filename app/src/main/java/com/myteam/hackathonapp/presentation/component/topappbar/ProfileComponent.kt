package com.myteam.hackathonapp.presentation.component.topappbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteam.hackathonapp.R
import com.myteam.hackathonapp.ui.theme.DopamineMarketTheme.colors
import com.myteam.hackathonapp.ui.theme.DopamineMarketTheme.typography


@Composable
fun ProfileComponent(
    username: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 17.dp, bottomStart = 17.dp, topEnd = 15.dp, bottomEnd = 15.dp))
            .width((80 + username.length*5).dp)
            .background(colors.User_Lightblue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Surface(
            modifier = Modifier.size(34.dp),
            shape = CircleShape,
            color  = colors.Sub_Blue
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(            // ② 기본 사람 아이콘
                    painter = painterResource(id = R.drawable.profile_icon),
                    contentDescription = "profile icon",
                    tint = colors.Main_Blue,
                    modifier = Modifier.size(23.dp)
                )
            }
        }
        Text(
            text = "$username",
            style = typography.SB_16,
            modifier = Modifier.padding(end = 12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileComponent() {
    ProfileComponent(
        username = "User10"
    )
}