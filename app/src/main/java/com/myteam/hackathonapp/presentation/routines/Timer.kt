import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myteam.hackathonapp.R
import com.myteam.hackathonapp.presentation.routines.component.TimeFormatter
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


@Composable
fun Timer(
    totalTime: Long,
    handleColor: Color,
    inactiveBarColor: Color,
    activeBarColor: Color,
    modifier: Modifier = Modifier,
    initialValue: Float = 1f,
    strokeWidth: Dp = 5.dp
) {
    var size by remember { mutableStateOf(IntSize.Zero) }
    var value by remember { mutableStateOf(initialValue) }
    var currentTime by remember { mutableStateOf(totalTime) }
    var isTimeRunning by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = currentTime, key2 = isTimeRunning) {
        if (currentTime > 0 && isTimeRunning) {
            delay(100L)
            currentTime -= 100L
            value = currentTime / totalTime.toFloat()
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.onSizeChanged { size = it }
    ) {
        // ellipse_188 (흰색 원 - 가운데)
        Image(
            painter = painterResource(id = R.drawable.ellipse_188),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        // 진행 바 (Canvas로 파란색 진행 상황 표시)
        Canvas(modifier = Modifier.fillMaxSize()) {
            // 진행 바 (파란색)
            drawArc(
                color = activeBarColor,
                startAngle = -90f, // x축 양의 방향 기준 90도
                sweepAngle = 360f * (1f - value), // 경과 시간만큼 채움
                useCenter = false,
                size = Size(size.width.toFloat(), size.height.toFloat()),
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }

        // 중앙 UI
        if (!isTimeRunning && currentTime > 0) {
            // 플레이 버튼 (시작 전)
            IconButton(
                onClick = { isTimeRunning = true },
                modifier = Modifier.size(80.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Start",
                    tint = Color(0xFF2196F3),
                    modifier = Modifier.size(48.dp)
                )
            }
        } else if (isTimeRunning && currentTime > 0) {
            // 시간 표시 (실행 중) - 클릭해서 일시정지
            Text(
                text = TimeFormatter.formatTime(currentTime), // 분리된 함수 사용
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.clickable { isTimeRunning = false }
            )
        } else {
            // 완료 상태
            Text(
                text = "완료!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4CAF50)
            )
        }
    }
}
