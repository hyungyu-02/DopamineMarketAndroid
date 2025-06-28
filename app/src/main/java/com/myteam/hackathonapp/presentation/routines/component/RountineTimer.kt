
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


@Composable
fun RoutineTimer(
    totalTime: Long,
    handleColor: Color,
    inactiveBarColor: Color,
    activeBarColor: Color,
    modifier: Modifier = Modifier,
    initialValue: Float = 1f,
    strokeWidth: Dp = 5.dp
) {
    // 기존 Timer 컴포넌트와 동일한 상태 관리
    var size by remember { mutableStateOf(IntSize.Zero) }
    var value by remember { mutableStateOf(initialValue) }
    var currentTime by remember { mutableStateOf(totalTime) }
    var isTimeRunning by remember { mutableStateOf(false) }

    // 기존 Timer 컴포넌트와 동일한 LaunchedEffect
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
        // 기존 Timer 컴포넌트와 동일한 Canvas 로직
        Canvas(modifier = modifier) {
            // 1. 비활성 바 (배경 원) - 기존 로직 그대로
            drawArc(
                color = inactiveBarColor,
                startAngle = -90f, // x축 양의 방향 기준 90도
                sweepAngle = 360f,
                useCenter = false,
                size = Size(size.width.toFloat(), size.height.toFloat()),
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )

            // 2. 활성 바 (시간이 흐른 만큼 채워짐) - 기존 로직 그대로
            drawArc(
                color = activeBarColor,
                startAngle = -90f,
                sweepAngle = 360f * (1f - value), // 경과 시간만큼 채움
                useCenter = false,
                size = Size(size.width.toFloat(), size.height.toFloat()),
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )

            // 3. 핸들 위치 계산 - 기존 로직 그대로 (단, 표시하지 않음)
            // 필요시 핸들을 그리려면 기존 Timer 컴포넌트의 로직 사용
        }

        // UI 요소들 - 이미지에 맞게 변형
        if (!isTimeRunning && currentTime > 0) {
            // 플레이 버튼 (타이머 시작 전)
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
            // 시간 표시 (타이머 실행 중)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = formatTime(currentTime),
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                IconButton(
                    onClick = { isTimeRunning = false },
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_pause),
                        contentDescription = "Pause",
                        tint = Color(0xFF2196F3),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        } else {
            // 타이머 완료
            Text(
                text = "완료!",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4CAF50)
            )
        }
    }
}

// 시간 포맷 함수
private fun formatTime(timeInMillis: Long): String {
    val totalSeconds = timeInMillis / 1000
    val minutes = totalSeconds / 60
    val seconds = totalSeconds % 60
    return String.format("%d:%02d", minutes, seconds)
}
