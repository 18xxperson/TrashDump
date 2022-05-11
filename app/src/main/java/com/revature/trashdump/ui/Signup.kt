package com.revature.trashdump.ui

import android.annotation.SuppressLint
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.revature.trashdump.data.User
import com.revature.trashdump.viewmodel.UserViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

@SuppressLint("UnrememberedGetBackStackEntry")
@Composable
fun Signup(userViewModel: UserViewModel,navController: NavController)
{
    val context= LocalContext.current
    var username by remember{ mutableStateOf("")}
    var password by remember { mutableStateOf("") }
    val scope= rememberCoroutineScope()
    try {
        if (navController.currentBackStackEntry == navController.getBackStackEntry(Screens.LoginScreen.route)) {
            Toast.makeText(context, "Please enter a different username", Toast.LENGTH_LONG).show()
        }
    }catch (e: Exception)
    {

    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Create your account",fontSize = 25.sp)
        Spacer(modifier = Modifier.height(50.dp))
        TextField(value = username, onValueChange = {
            username=it
        },label = {
            Text(text = "Create username")
        })
        Spacer(modifier = Modifier.height(50.dp))
        TextField(value = password, onValueChange = {
            password=it
        },label = {
            Text(text = "Create password")
        })
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = {
            scope.launch {
                userViewModel.insertUser(User(username,password),navController)
            }
            navController.navigate(Screens.LoginScreen.route)
        },Modifier.fillMaxWidth()) {
            Text(text = "Signup")
        }
    }
}