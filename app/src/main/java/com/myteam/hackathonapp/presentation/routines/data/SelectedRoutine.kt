package com.myteam.hackathonapp.presentation.routines.data


// 루틴 설정 후 전달받는 데이터
data class SelectedRoutine(
    val id: String,
    val name: String,
    val iconResource: String,
    val durationMillis: Long,
    val category: String,
    val description: String = ""
)

// 샘플 데이터 생성 함수
fun createSampleRoutine(): SelectedRoutine {
    return SelectedRoutine(
        id = "routine_morning_jog_001",
        name = "Morning Jog",
        iconResource = "ic_run",
        durationMillis = 10 * 60 * 1000L + 15 * 1000L, // 10분 15초
        category = "exercise",
        description = "아침 조깅 루틴"
    )
}
