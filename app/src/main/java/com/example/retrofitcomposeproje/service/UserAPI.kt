package com.example.retrofitcomposeproje.service

import com.example.retrofitcomposeproje.model.User
import retrofit2.http.GET

interface UserAPI {

    @GET("users")
    suspend fun getCurrentUserData(): List<User>


}