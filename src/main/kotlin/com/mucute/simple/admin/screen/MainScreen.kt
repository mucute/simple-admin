package com.mucute.simple.admin.screen

import DesktopViewModelStoreOwner
import androidx.compose.foundation.HorizontalScrollbar
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AccountBox
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mucute.simple.admin.composable.*
import com.mucute.simple.admin.config.Menus
import com.mucute.simple.admin.network.Api
import com.mucute.simple.admin.network.entity.User
import com.mucute.simple.admin.viewmodel.UserScreenState
import com.mucute.simple.admin.viewmodel.UserViewModel
import okhttp3.Callback
import retrofit2.Call
import retrofit2.Response

@Composable
fun MainScreen() {
    var selectedIndex by remember { mutableStateOf(0) }
    val navHostController = rememberNavController()
    Row {
        NavigationBar {
            Menus.main.forEachIndexed { index, menu ->
                NavigationItem(
                    selected = selectedIndex == index,
                    onClick = {
                        navHostController.navigate(menu.route)
                        selectedIndex = index
                    },
                    icon = { Icon(imageVector = menu.icon, contentDescription = null) },
                    label = { Text(menu.title) })
            }

        }
        NavHost(navController = navHostController, modifier = Modifier.fillMaxSize(), startDestination = "user") {
            composable("user") {
                UserScreenContent()
            }
        }
    }
}

