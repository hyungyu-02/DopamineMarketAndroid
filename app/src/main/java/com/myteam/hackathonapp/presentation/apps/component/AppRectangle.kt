package com.myteam.hackathonapp.presentation.apps.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteam.hackathonapp.R
import com.myteam.hackathonapp.ui.theme.DopamineMarketTheme.typography


@Composable
fun AppRectangle(
    appName: String,
    isSelected: Boolean = false,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var isDeleteDialogVisible by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .width(89.dp)
            .height(91.dp)
            .shadow(elevation = 3.dp, clip = true, shape = RoundedCornerShape(25.dp))
            .background(Color.White)
            .combinedClickable(
                onClick = {},
                onLongClick = {
                    isDeleteDialogVisible = true
                }
            )
    ) {
        // 텍스트로 앱 이름 표시
        Text(
            text = appName,
            style = typography.SB_12,
            modifier = Modifier.fillMaxWidth().align(alignment = Alignment.TopCenter).padding(top = 25.dp),
            textAlign = TextAlign.Center,
            maxLines = 2
        )
        Image(
            painter = if (isSelected) painterResource(id = R.drawable.lock) else painterResource(id = R.drawable.unlock),
            contentDescription = "lock Icon",
            modifier = Modifier.height(40.dp).align(Alignment.BottomCenter).padding(bottom = 18.dp),
        )
    }
    if (isDeleteDialogVisible) {
        AlertDialog(
            onDismissRequest = { isDeleteDialogVisible = false },
            title = { Text(text = "삭제 확인") },
            text = { Text(text = "삭제하시겠습니까?") },
            confirmButton = {
                TextButton(onClick = {
                    isDeleteDialogVisible = false
                }) {
                    Text("삭제")
                }
            },
            dismissButton = {
                TextButton(onClick = { isDeleteDialogVisible = false }) {
                    Text("취소")
                }
            }
        )
    }
}

@Composable
fun AddAppRectangle(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(89.dp)
            .height(91.dp)
            //.aspectRatio(1f)
            .shadow(elevation = 3.dp, clip = true, shape = RoundedCornerShape(25.dp))
            .background(Color.White)
            .clickable { onClick() }
    ){
        Image(
            painter = painterResource(id = R.drawable.lockappplusicon),
            contentDescription = "Add App Icon",
            modifier = Modifier
                .fillMaxWidth()
                .height(22.dp)
                .align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppRectanglePreview() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp) // 프리뷰에 패딩 추가
    ) {
        AppRectangle(
            appName = "YouTube",
            isSelected = false,
            modifier = Modifier.width(80.dp) // 프리뷰용 고정 크기
        )
        AppRectangle(
            appName = "Instagram",
            isSelected = true,
            modifier = Modifier.width(80.dp) // 프리뷰용 고정 크기
        )
        AddAppRectangle(
            modifier = Modifier.width(80.dp) // 프리뷰용 고정 크기
        )
    }
}
