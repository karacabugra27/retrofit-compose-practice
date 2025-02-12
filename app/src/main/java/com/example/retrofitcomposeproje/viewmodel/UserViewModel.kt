package com.example.retrofitcomposeproje.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitcomposeproje.model.User
import com.example.retrofitcomposeproje.service.UserAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    val userData = mutableStateOf<List<User>>(listOf())

    fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            userData.value = UserAPIService.RetrofitClient.apiService.getCurrentUserData()
        }
    }

}