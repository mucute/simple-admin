package com.mucute.simple.admin.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mucute.simple.admin.network.Api
import com.mucute.simple.admin.network.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import success

class UserViewModel : ViewModel() {
    val userScreenState = MutableStateFlow<UserScreenState>(UserScreenState.Loading)

    init {
        Api.user.getAllUser(0).success {
            println(it)
            CoroutineScope(Dispatchers.Default).launch {
                userScreenState.emit(UserScreenState.Success(it.data))
            }
        }
    }
}

sealed class UserScreenState {
    data object Loading : UserScreenState()
    data object Error : UserScreenState()
    data class Success(val users: MutableList<User>) : UserScreenState()
}