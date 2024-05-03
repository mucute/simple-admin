package com.mucute.simple.admin.theme

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Stable
class SimpleColor(
    primary: Color,
    background: Color,
) {
    var primary by mutableStateOf(primary, structuralEqualityPolicy())
        internal set
    var background by mutableStateOf(primary, structuralEqualityPolicy())
        internal set
}
fun lightColorScheme() = SimpleColor(
    primary = Color(0xFF6200EE),
    background = Color(0xFF6200EE),
)