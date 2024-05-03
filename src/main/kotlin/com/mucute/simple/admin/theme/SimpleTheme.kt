package com.mucute.simple.admin.theme

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun SimpleTheme(content:@Composable () -> Unit) {
    MaterialTheme {

    }
    CompositionLocalProvider(content = content)
}

object SimpleTheme {
    val colors: SimpleColor
        @Composable
        @ReadOnlyComposable
        get() = LocalSimpleColor.current
    val typography: SimpleTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalSimpleTypography.current

    val shapes: SimpleShape
        @Composable
        @ReadOnlyComposable
        get() = LocalSimpleShape.current
}

val LocalSimpleColor = staticCompositionLocalOf { lightColorScheme() }
internal val LocalSimpleTypography = staticCompositionLocalOf { SimpleTypography() }
internal val LocalSimpleShape = staticCompositionLocalOf { SimpleShape() }
