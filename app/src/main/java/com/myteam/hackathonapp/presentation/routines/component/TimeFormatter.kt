package com.myteam.hackathonapp.presentation.routines.component

/**
 * 시간 관련 유틸리티 함수들
 */
object TimeFormatter {

    /**
     * 밀리초를 분:초 형태로 변환
     * @param timeInMillis 밀리초 단위 시간
     * @return "MM:SS" 형태의 문자열
     */
    fun formatTime(timeInMillis: Long): String {
        val totalSeconds = timeInMillis / 1000
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        return String.format("%d:%02d", minutes, seconds)
    }

    /**
     * 시간을 시:분:초 형태로 변환 (긴 시간용)
     * @param timeInMillis 밀리초 단위 시간
     * @return "HH:MM:SS" 형태의 문자열
     */
    fun formatTimeWithHours(timeInMillis: Long): String {
        val totalSeconds = timeInMillis / 1000
        val hours = totalSeconds / 3600
        val minutes = (totalSeconds % 3600) / 60
        val seconds = totalSeconds % 60
        return String.format("%d:%02d:%02d", hours, minutes, seconds)
    }
}
