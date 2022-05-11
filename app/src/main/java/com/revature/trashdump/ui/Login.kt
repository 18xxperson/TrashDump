package com.revature.trashdump.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.revature.trashdump.viewmodel.UserViewModel

@Composable
fun Login(userViewModel: UserViewModel,navController: NavController)
{
    var username by remember{ mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Login",fontSize = 25.sp)
        Spacer(modifier = Modifier.height(50.dp))
        TextField(value = username, onValueChange = {
            username = it
        },label = {
            Text("Enter username")
        })
        Spacer(modifier = Modifier.height(50.dp))
        TextField(value = password, onValueChange = {
            password = it
        },label = {
            Text(text = "Enter password")
        },)
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = {

        },Modifier.fillMaxWidth()) {
            Text(text = "Login")
        }
    }
}