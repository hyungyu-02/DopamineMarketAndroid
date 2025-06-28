package com.myteam.hackathonapp.presentation.routines.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myteam.hackathonapp.R

@Composable
fun RoutineComponent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .border(1.dp, Color.Blue)
            .background(color = Color(0xFFFFFFFF)),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(color = Color(0xFFDBEAFE))
                ){
                    Text(
                        modifier = Modifier
                            .align(Alignment.Center),
                        text = "\uD83C\uDFC3",
                        style = TextStyle(color = Color.White)
                    )
                }

                Box(
                    modifier = Modifier
                        .padding(start = 13.dp)
                ) {
                    Text(
                        text = "Morning Jog",
                        fontSize = 13.sp,
                        fontWeight = FontWeight(700)
                    )
                    Text(
                        modifier = Modifier
                            .padding(top = 20.dp),
                        text = "25min • exercise",
                        fontSize = 11.sp,
                        color = Color(0x80000000)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .size(49.dp, 36.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .shadow(1.dp)
                    .background(color = Color(0xFF3B73ED))
                    .clickable(
                        onClick = {

                        }
                    )
            ){
                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = "Start",
                    fontWeight = FontWeight(500),
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RoutineComponentPreview(modifier: Modifier = Modifier) {
    RoutineComponent()
}