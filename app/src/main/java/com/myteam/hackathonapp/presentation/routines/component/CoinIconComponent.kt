package com.myteam.hackathonapp.presentation.routines.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myteam.hackathonapp.R

@Composable
fun CoinScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .size(177.dp, 175.dp)
            .clip(RoundedCornerShape(13.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            modifier = Modifier
                .padding(top = 10.dp)
                .size(56.dp),
            painter = painterResource(id = R.drawable.home_img_coin),
            contentDescription = "coin"
        )
        Text(
            modifier = Modifier
                .padding(
                    bottom = 10.dp,
                    top = 13.1.dp),
            text = "1코인 획득!",
            fontSize = 15.sp,
            fontWeight = FontWeight(600)
        )
        Box(
            modifier = Modifier
                .size(130.dp, 37.dp)
                .clip(RoundedCornerShape(6.dp))
                .border(0.5.dp, color = Color(0xFFCACACA), shape = RoundedCornerShape(6.dp))
                .clickable(onClick = {

                }
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "확인"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CoinScreenPreview(modifier: Modifier = Modifier) {
    CoinScreen()
}