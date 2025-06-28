package com.myteam.hackathonapp.presentation.routines.screen


import Timer
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.myteam.hackathonapp.R
import com.myteam.hackathonapp.presentation.routines.component.ChallengeHeader
import com.myteam.hackathonapp.presentation.routines.component.TimeFormatter
import com.myteam.hackathonapp.presentation.routines.data.SelectedRoutine
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

// 루틴 설정 후 전달받는 데이터
data class SelectedRoutine(
    val id: String,
    val name: String,
    val iconResource: String,
    val durationMillis: Long,
    val category: String,
    val description: String = ""
)

@Composable
fun TimerScreen(
    selectedRoutine: SelectedRoutine,
    onRoutineComplete: (SelectedRoutine) -> Unit,
    onRoutineCancel: (SelectedRoutine) -> Unit,
    onDismiss: () -> Unit = {} // 모달 닫기용
) {
    // 타이머 상태 관리
    var currentTime by remember { mutableStateOf(selectedRoutine.durationMillis) }
    var isTimeRunning by remember { mutableStateOf(false) }

    // 진행 비율 계산 (1.0에서 0.0으로)
    val value = currentTime / selectedRoutine.durationMillis.toFloat()

    // 타이머 로직
    LaunchedEffect(key1 = currentTime, key2 = isTimeRunning) {
        if (currentTime > 0 && isTimeRunning) {
            delay(100L)
            currentTime -= 100L
        }
    }

    // 아이콘 리소스 매핑
    val iconRes = mapIconResource(selectedRoutine.iconResource)
    val iconColor = mapCategoryColor(selectedRoutine.category)

    // 모달 다이얼로그 형태로 표시
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        // 모달 카드
        Card(
            modifier = Modifier
                .size(width = 310.dp, height = 405.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(16.dp)
                ),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // 상단 헤더 (크기 조정)
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // 아이콘을 원형 배경으로 감싸기
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.size(48.dp)
                    ) {
                        // 배경 원
                        Image(
                            painter = painterResource(id = R.drawable.ellipse_182),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )

                        // 아이콘
                        Icon(
                            painter = painterResource(id = iconRes),
                            contentDescription = selectedRoutine.name,
                            tint = iconColor,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = selectedRoutine.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Divider(
                        modifier = Modifier
                            .width(100.dp)
                            .padding(vertical = 12.dp),
                        color = Color.LightGray
                    )
                }

                // 중앙 타이머
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.size(160.dp)
                ) {
                    // ellipse_188 (파란 원 - 배경)
                    Image(
                        painter = painterResource(id = R.drawable.ellipse_187),
                        contentDescription = null,
                        modifier = Modifier.size(160.dp)
                    )

                    // ellipse_187 (흰색 원)
                    Image(
                        painter = painterResource(id = R.drawable.ellipse_188),
                        contentDescription = null,
                        modifier = Modifier.size(144.dp)
                    )

                    // 진행 바
                    Canvas(modifier = Modifier.size(144.dp)) {
                        drawArc(
                            color = Color(0xFF2196F3),
                            startAngle = -90f,
                            sweepAngle = 360f * (1f - value),
                            useCenter = false,
                            style = Stroke(
                                width = 6.dp.toPx(),
                                cap = StrokeCap.Round
                            )
                        )
                    }

                    // 화살표 핸들러
                    Canvas(modifier = Modifier.size(144.dp)) {
                        if (currentTime > 0) {
                            val center = Offset(size.width / 2f, size.height / 2f)
                            val beta = (-90f + 360f * (1f - value)) * (PI / 180f).toFloat()
                            val radius = size.width / 2f - 6.dp.toPx()
                            val arrowX = center.x + cos(beta) * radius
                            val arrowY = center.y + sin(beta) * radius
                            val arrowRotation = (-90f + 360f * (1f - value)) + 90f

                            translate(arrowX, arrowY) {
                                rotate(arrowRotation) {
                                    val arrowPath = androidx.compose.ui.graphics.Path().apply {
                                        moveTo(0f, -8f)
                                        lineTo(-5f, 5f)
                                        lineTo(0f, 2f)
                                        lineTo(5f, 5f)
                                        close()
                                    }

                                    drawPath(
                                        path = arrowPath,
                                        color = Color(0xFF1976D2)
                                    )
                                }
                            }
                        }
                    }

                    // 중앙 컨텐츠
                    when {
                        !isTimeRunning && currentTime > 0 -> {
                            IconButton(
                                onClick = { isTimeRunning = true },
                                modifier = Modifier.size(48.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.PlayArrow,
                                    contentDescription = "Start",
                                    tint = Color(0xFF2196F3),
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                        isTimeRunning && currentTime > 0 -> {
                            Text(
                                text = TimeFormatter.formatTime(currentTime),
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                modifier = Modifier.clickable { isTimeRunning = false }
                            )
                        }
                        else -> {
                            Text(
                                text = "완료!",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF4CAF50)
                            )
                        }
                    }
                }

                // 하단 버튼들
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = { onRoutineComplete(selectedRoutine) },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2196F3)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Done",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                    }

                    OutlinedButton(
                        onClick = { onRoutineCancel(selectedRoutine) },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "취소",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}

// 매핑 함수들 (기존과 동일)
private fun mapIconResource(iconResource: String): Int {
    return when(iconResource) {
        "ic_sprout" -> R.drawable.ic_sprout
        "ic_run" -> R.drawable.ic_run
        "ic_book" -> R.drawable.ic_book
        "ic_water" -> R.drawable.ic_water
        else -> R.drawable.ic_sprout
    }
}

private fun mapCategoryColor(category: String): Color {
    return when(category) {
        "exercise" -> Color(0xFF4CAF50)
        "reading" -> Color(0xFF9C27B0)
        "meditation" -> Color(0xFF00BCD4)
        "study" -> Color(0xFFFF9800)
        else -> Color(0xFF2196F3)
    }
}

fun createSampleRoutine(): SelectedRoutine {
    return SelectedRoutine(
        id = "routine_morning_jog_001",
        name = "Morning Jog",
        iconResource = "ic_run",
        durationMillis = 10 * 60 * 1000L + 15 * 1000L,
        category = "exercise",
        description = "아침 조깅 루틴"
    )
}