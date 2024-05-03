package com.mucute.simple.admin.composable

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AccountBox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.mucute.simple.admin.screen.UserScreenContent
import com.mucute.simple.admin.theme.SimpleTheme
import kotlin.reflect.KProperty

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Simple后台管理系统") {
        val menu = mutableListOf(
            "用户管理" to Icons.TwoTone.AccountBox,
            "升级管理" to Icons.TwoTone.AccountBox,
            "插件" to Icons.TwoTone.AccountBox,
            "Space管理" to Icons.TwoTone.AccountBox,
        )
        var selectedIndex by remember { mutableStateOf(0) }

            NavigationBar {
                menu.forEachIndexed { index, menu ->
                    NavigationItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = { Icon(imageVector = menu.second, contentDescription = null) },
                        label = { Text(menu.first) })
                }
        }
    }

}

@Preview
@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope) -> Unit
) {
    Column(
        modifier = modifier
            .padding(vertical = 8.dp)
            .width(IntrinsicSize.Max),
        content = content
    )
}

@Composable
fun NavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selectedContentColor: Color = Color.White,
    unselectedContentColor: Color = Color.Black
) {
    Row(
        Modifier.fillMaxWidth().padding(4.dp).then(
            if (selected) Modifier.background(
                SimpleTheme.colors.primary,
                shape = SimpleTheme.shapes.default
            ) else Modifier
        )
            .clip(SimpleTheme.shapes.default)
            .clickable {
                onClick()
            }
            .padding(start = 4.dp, top = 4.dp, bottom = 4.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CompositionLocalProvider(LocalContentColor provides if (selected) selectedContentColor else unselectedContentColor) {
            icon()
            Box(Modifier.padding(start = 8.dp)) {
                label()

            }

        }
    }
}