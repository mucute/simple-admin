package com.mucute.simple.admin.screen

import DesktopViewModelStoreOwner
import androidx.compose.foundation.HorizontalScrollbar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mucute.simple.admin.composable.Header
import com.mucute.simple.admin.composable.Table
import com.mucute.simple.admin.composable.TableItem
import com.mucute.simple.admin.composable.TableRow
import com.mucute.simple.admin.viewmodel.UserScreenState
import com.mucute.simple.admin.viewmodel.UserViewModel

@Composable
fun UserScreenContent() {
    val viewModelStore = remember { ViewModelStore() }
    val viewModelStoreOwner = remember { DesktopViewModelStoreOwner(viewModelStore) }
    val viewModel = viewModel(UserViewModel::class, viewModelStoreOwner)
    val scrollState = rememberScrollState()
    when (val state = viewModel.userScreenState.collectAsState().value) {
        UserScreenState.Error -> {
            Text("Error")
        }

        UserScreenState.Loading -> {

        }

        is UserScreenState.Success -> {
            Column {
                Table {
                    Header(scrollState) {
                        TableItem {
                            Text("ID")
                        }
                        TableItem {
                            Text("用户名")
                        }
                        TableItem {
                            Text("邮箱")
                        }
                        TableItem {
                            Text("性别")
                        }
                        TableItem {
                            Text("激活")
                        }
                        TableItem {
                            Text("注册时间")
                        }
                    }
                    for (user in state.users) {
                        TableRow(scrollState) {
                            TableItem {
                                Text(user.id.toString())
                            }
                            TableItem {
                                Text(user.name!!)
                            }
                            TableItem {
                                Text(user.email!!)
                            }
                            TableItem {
                                Text(user.sex)
                            }
                            TableItem {
                                Text(user.activated.toString())
                            }
                        }
                    }
                }
                HorizontalScrollbar(rememberScrollbarAdapter(scrollState))
            }
        }
    }
}