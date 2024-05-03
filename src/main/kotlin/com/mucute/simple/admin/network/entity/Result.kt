package com.mucute.simple.admin.network.entity

data class Result<T>(
    val message: String,
    val data: T
)
data class ArrayResult<T>(
    val message: String,
    val data: MutableList<T>
)