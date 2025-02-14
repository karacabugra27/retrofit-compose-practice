package com.example.retrofitcomposeproje.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.retrofitcomposeproje.model.User
import com.google.gson.Gson

@Composable
fun userList(userList: List<User>, navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(userList) {
            userListRow(it, navController)
        }
    }
}

@Composable
fun userListRow(user: User, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .border(BorderStroke(2.dp, Color.Black))
            .clickable {
                navController.navigate("detay_ekrani/${Gson().toJson(user)}")
            }
            .padding(5.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = user.name,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = user.email,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = user.website,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = user.phone,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(3.dp)
        )
    }
}

