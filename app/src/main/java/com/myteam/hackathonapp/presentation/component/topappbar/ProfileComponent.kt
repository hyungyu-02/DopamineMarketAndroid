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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 17.dp, bottomStart = 17.dp, topEnd = 15.dp, bottomEnd = 15.dp))
            .width((80 + username.length*5).dp)
            .background(Color(0xB0EFF6FF)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Surface(
            modifier = Modifier.size(34.dp),
            shape = CircleShape,
            color  = Color(0xFFDBEAFE)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(            // ② 기본 사람 아이콘
                    painter = painterResource(id = R.drawable.profile_icon),
                    contentDescription = "profile icon",
                    tint = Color(0xFF3B73ED),
                    modifier = Modifier.size(23.dp)
                )
            }
        }
        Text(
            text = "$username",
            style = TextStyle(
                fontSize = 16.sp,
                //fontFamily = FontFamily(Font(R.font.segoe_ui)),
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
            ),
            modifier = Modifier.padding(end = 12.dp)
        )
    }

//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = modifier
//            .background(
//                color = Color(0xB0EFF6FF),
//                shape = RoundedCornerShape(15.dp)
//            )
//            .padding(end = 16.dp)
//    ) {
//        // 원형 아이콘 (drawable 사용)
//        Icon(
//            imageVector = Icons.Default.Person,
//            contentDescription = "User",
//            tint = Color.Blue,
//            modifier = Modifier
//                .size(40.dp)
//                .paint(
//                    painter = painterResource(R.drawable.profile_icon),
//                    contentScale = ContentScale.FillBounds
//                )
//                .padding(10.dp)
//        )
//
//        Spacer(modifier = Modifier.width(15.dp))
//
//        Text(
//            text = username,
//            fontSize = 16.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color(0xFF333333)
//        )
//    }
}

@Preview(showBackground = true)
@Composable
fun ProfileComponent() {
    ProfileComponent(
        username = "User10"
    )
}