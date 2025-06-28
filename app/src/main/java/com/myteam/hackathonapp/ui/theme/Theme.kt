package com.myteam.hackathonapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object DopamineMarketTheme {
    val colors: DopamineMarketColors
        @Composable
        @ReadOnlyComposable
        get() = LocalDopamineMarketColorsProvider.current

    val typography: DopamineMarketTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalDopamineMarketTypographyProvider.current
}

@Composable
fun HackathonAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content = content
    )
}