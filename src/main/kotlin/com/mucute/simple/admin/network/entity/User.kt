package com.mucute.simple.admin.network.entity

data class User(
    val id: Long,
    val avatar:String,
    val userId: String,
    val name: String,
    val account: String,
    val password: String,
    val email: String,
    val sex: String,
    val activated: Boolean,
    val registerDate: String
)