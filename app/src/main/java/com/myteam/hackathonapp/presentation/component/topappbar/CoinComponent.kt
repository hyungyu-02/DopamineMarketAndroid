package com.myteam.hackathonapp.presentation.component.topappbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteam.hackathonapp.ui.theme.DopamineMarketTheme.colors
import com.myteam.hackathonapp.ui.theme.DopamineMarketTheme.typography


@Composable
fun CoinComponent(
    coins: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Coins: ",
            style = typography.B_16
        )

        Spacer(modifier = Modifier.width(10.dp))

        Surface(
            modifier = Modifier.size(34.dp),
            shape = CircleShape,
            color  = colors.Main_Blue
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = coins.toString(),
                    style = typography.B_16,
                    color = colors.White,
                    maxLines = 1
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun CoinComponent() {
    CoinComponent(
        coins=10,
    )
}