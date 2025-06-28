package com.myteam.hackathonapp.presentation.my

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteam.hackathonapp.R
import com.myteam.hackathonapp.core.component.HackathonTitle
import com.myteam.hackathonapp.core.util.modifier.noRippleClickable

@Composable
fun MyScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HackathonTitle(
            title = "My Screen"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(R.drawable.ic_my),
            contentDescription = "My Screen image",
            modifier = Modifier
                .size(50.dp)
                .noRippleClickable{}
        )
    }
}

@Preview
@Composable
private fun MyScreenPreview() {
    MyScreen()
}