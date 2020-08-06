package com.example.binarchapter7.network

import com.example.binarchapter7.pojo.PostBodyRegister
import com.example.binarchapter7.pojo.PostLoginBody
import com.example.binarchapter7.pojo.PostLoginResponse
import com.example.binarchapter7.pojo.PostRegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST ("login")
    fun validateLogin(@Body body: PostLoginBody): Call<PostLoginResponse>

    @POST("register")
    fun registerUser(@Body bodyRegister: PostBodyRegister): Call<PostRegisterResponse>
}