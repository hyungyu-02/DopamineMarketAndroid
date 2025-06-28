package com.myteam.hackathonapp.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.myteam.hackathonapp.R

val dopamineMarketFontBold = FontFamily(Font(R.font.segoe_ui_variable_static_display_bold))
val dopamineMarketFontRegular = FontFamily(Font(R.font.segoe_ui_variable_static_display_regular))
val dopamineMarketFontSemiBold = FontFamily(Font(R.font.segoe_ui_variable_static_display_semibold))
val dopamineMarketFontSemiLight = FontFamily(Font(R.font.segoe_ui_variable_static_display_semilight))

@Immutable
data class DopamineMarketTypography(
    val B_32: TextStyle,
    val B_20: TextStyle,
    val B_16: TextStyle,
    val B_13: TextStyle,

    val SB_18: TextStyle,
    val SB_16: TextStyle,
    val SB_15: TextStyle,
    val SB_14: TextStyle,
    val SB_12: TextStyle,
    val SB_11: TextStyle,

    val R_35: TextStyle,
    val R_30: TextStyle,
    val R_16: TextStyle,
    val R_15: TextStyle,
    val R_13: TextStyle,
    val R_11: TextStyle,

    val SL_12: TextStyle
)

val defaultDopamineMarketTypography = DopamineMarketTypography(
    B_32 = TextStyle(
        fontFamily = dopamineMarketFontBold,
        fontSize = 32.sp,
        lineHeight = 32.sp
    ),
    B_20 = TextStyle(
        fontFamily = dopamineMarketFontBold,
        fontSize = 20.sp,
        lineHeight = 20.sp
    ),
    B_16 = TextStyle(
        fontFamily = dopamineMarketFontBold,
        fontSize = 16.sp,
        lineHeight = 16.sp
    ),
    B_13 = TextStyle(
        fontFamily = dopamineMarketFontBold,
        fontSize = 13.sp,
        lineHeight = 13.sp
    ),
    SB_18 = TextStyle(
        fontFamily = dopamineMarketFontSemiBold,
        fontSize = 18.sp,
        lineHeight = 18.sp
    ),
    SB_16 = TextStyle(
        fontFamily = dopamineMarketFontSemiBold,
        fontSize = 16.sp,
        lineHeight = 16.sp
    ),
    SB_15 = TextStyle(
        fontFamily = dopamineMarketFontSemiBold,
        fontSize = 15.sp,
        lineHeight = 15.sp
    ),
    SB_14 = TextStyle(
        fontFamily = dopamineMarketFontSemiBold,
        fontSize = 14.sp,
        lineHeight = 14.sp
    ),
    SB_12 = TextStyle(
        fontFamily = dopamineMarketFontSemiBold,
        fontSize = 12.sp,
        lineHeight = 12.sp
    ),
    SB_11 = TextStyle(
        fontFamily = dopamineMarketFontSemiBold,
        fontSize = 11.sp,
        lineHeight = 11.sp
    ),
    R_35 = TextStyle(
        fontFamily = dopamineMarketFontRegular,
        fontSize = 35.sp,
        lineHeight = 35.sp
    ),
    R_30 = TextStyle(
        fontFamily = dopamineMarketFontRegular,
        fontSize = 30.sp,
        lineHeight = 30.sp
    ),
    R_16 = TextStyle(
        fontFamily = dopamineMarketFontRegular,
        fontSize = 16.sp,
        lineHeight = 16.sp
    ),
    R_15 = TextStyle(
        fontFamily = dopamineMarketFontRegular,
        fontSize = 15.sp,
        lineHeight = 15.sp
    ),
    R_13 = TextStyle(
        fontFamily = dopamineMarketFontRegular,
        fontSize = 13.sp,
        lineHeight = 13.sp
    ),
    R_11 = TextStyle(
        fontFamily = dopamineMarketFontRegular,
        fontSize = 11.sp,
        lineHeight = 11.sp
    ),
    SL_12 = TextStyle(
        fontFamily = dopamineMarketFontSemiLight,
        fontSize = 12.sp,
        lineHeight = 12.sp
    )
)

val LocalDopamineMarketTypographyProvider = staticCompositionLocalOf { defaultDopamineMarketTypography }