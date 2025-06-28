package com.myteam.hackathonapp.presentation.apps.dialog

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.myteam.hackathonapp.ui.theme.DopamineMarketTheme.colors
import com.myteam.hackathonapp.ui.theme.DopamineMarketTheme.typography

@Composable
fun CoinWarning(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (showDialog) {
        Dialog(onDismissRequest = onDismiss) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(148.dp)
                    .padding(horizontal = 40.dp),
                shape = RoundedCornerShape(13.dp),
                colors = CardDefaults.cardColors(containerColor = colors.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "코인이 부족합니다!",
                        style = typography.B_16,
                        modifier = Modifier.padding(top = 40.dp)
                    )

                    Column(
                        modifier = Modifier
                            .padding(top = 18.dp)
                            .width(130.dp)
                            .height(34.dp)
                            .border(
                                width = 0.5.dp,
                                color = colors.Box_Grey,
                                shape = RoundedCornerShape(7.dp)
                            )
                            .clickable{
                                onConfirm()
                            },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "확인",
                            style =  typography.SB_11,
                            color = colors.Text_Sub_Black
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CoinWarningDialogPreview() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            CoinWarning(
                showDialog = true,
                onDismiss = {},
                onConfirm = {}
            )
        }
    }
}
