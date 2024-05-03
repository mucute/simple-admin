package com.mucute.simple.admin.network

import com.mucute.simple.admin.network.api.UserApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    private val retrofit = Retrofit.Builder().baseUrl("http://localhost:8080").addConverterFactory(GsonConverterFactory.create()).build();

    val user: UserApi = retrofit.create(UserApi::class.java)

}
