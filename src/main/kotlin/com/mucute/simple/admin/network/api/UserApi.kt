package com.mucute.simple.admin.network.api

import com.mucute.simple.admin.network.entity.ArrayResult
import com.mucute.simple.admin.network.entity.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("admin/api/user/all")
    fun getAllUser(@Query("page") page: Int): Call<ArrayResult<User>>
}