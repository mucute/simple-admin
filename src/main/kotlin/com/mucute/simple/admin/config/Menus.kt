package com.mucute.simple.admin.config

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AccountBox
import androidx.compose.material.icons.twotone.Apps
import androidx.compose.material.icons.twotone.Dashboard
import androidx.compose.ui.graphics.vector.ImageVector

object Menus {
    val main = mutableListOf(
        Menu("仪表盘", Icons.TwoTone.Dashboard, "dashboard"),
        Menu("用户管理", Icons.TwoTone.AccountBox, "user"),
        Menu("App升级管理", Icons.TwoTone.Apps, "app"),
        Menu("插件管理", Icons.TwoTone.Apps, "plugin"),
        Menu("Space", Icons.TwoTone.Apps, "space"),
        Menu("系统日志", Icons.TwoTone.Apps, "log"),
    )
}

class Menu(
    val title: String,
    val icon: ImageVector,
    val route: String,
)