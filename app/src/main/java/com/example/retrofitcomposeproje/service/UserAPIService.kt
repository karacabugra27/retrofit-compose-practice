package com.example.retrofitcomposeproje.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserAPIService {

    object RetrofitClient {
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()

        val apiService: UserAPI = retrofit.create(UserAPI::class.java)
    }
}