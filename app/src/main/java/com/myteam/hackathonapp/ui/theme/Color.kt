package com.myteam.hackathonapp.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)

val Main_Blue = Color(0xFF3B73ED)
val Sub_Blue = Color(0xFFDBEAFE)
val Delete_Red = Color(0xFFDD4A4A)
val Under_Menu_Grey = Color(0xFF9CA3AF)

val Text_Bold_Black = Color(0xFF000000)
val Text_Sub_Black = Color(0x80000000)   // 50 % 투명도

val Box_Grey = Color(0xFFCACACA)
val Background_Grey = Color(0xFFF6F6F9)

val Daily_Green = Color(0xCC40C740)   // 80 % 투명도
val Fixed_Red = Color(0xCCDD4A4A)   // 80 % 투명도

val User_Lightblue = Color(0xFFEFF6FF)

@Immutable
data class DopamineMarketColors(
    val White: Color,
    val Black: Color,
    val Main_Blue: Color,
    val Sub_Blue: Color,
    val Delete_Red: Color,
    val Under_Menu_Grey: Color,
    val Text_Bold_Black: Color,
    val Text_Sub_Black: Color,
    val Box_Grey: Color,
    val Background_Grey: Color,
    val Daily_Green: Color,
    val Fixed_Red: Color,
    val User_Lightblue: Color
)

val defaultDopamineMarketColors = DopamineMarketColors(
    White = White,
    Black = Black,
    Main_Blue = Main_Blue,
    Sub_Blue = Sub_Blue,
    Delete_Red = Delete_Red,
    Under_Menu_Grey = Under_Menu_Grey,
    Text_Bold_Black = Text_Bold_Black,
    Text_Sub_Black = Text_Sub_Black,
    Box_Grey = Box_Grey,
    Background_Grey = Background_Grey,
    Daily_Green = Daily_Green,
    Fixed_Red = Fixed_Red,
    User_Lightblue = User_Lightblue
)

val LocalDopamineMarketColorsProvider = staticCompositionLocalOf { defaultDopamineMarketColors }