package com.revature.trashdump.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.revature.trashdump.viewmodel.UserViewModel

@Composable
fun Login(userViewModel: UserViewModel,navController: NavController)
{
    var username by remember{ mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column() {

        TextField(value = username, onValueChange = {
            username = it
        },label = {
            Text("Enter username")
        })
        TextField(value = password, onValueChange = {
            password = it
        },label = {
            Text(text = "Enter password")
        })
    }
}