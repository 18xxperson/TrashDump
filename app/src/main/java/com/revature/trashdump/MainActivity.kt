package com.revature.trashdump

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.revature.trashdump.ui.Login
import com.revature.trashdump.ui.Screens
import com.revature.trashdump.ui.Signup
import com.revature.trashdump.ui.theme.TrashDumpTheme
import com.revature.trashdump.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        setContent {
            TrashDumpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigation(viewModel)
                }
            }
        }
    }
}

@Composable
fun Navigation(userViewModel: UserViewModel) {
    val navController= rememberNavController()
    NavHost(navController = navController,startDestination = Screens.MainScreen.route)
    {
       composable(Screens.MainScreen.route)
       {
           MainScreen(navController = navController)
       }
        composable(Screens.LoginScreen.route)
        {
            Login(userViewModel = userViewModel, navController = navController)
        }
        composable(Screens.SignupScreen.route)
        {
            Signup(userViewModel = userViewModel, navController = navController)
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Column() {
        Button(onClick = {
            navController.navigate(Screens.LoginScreen.route)
        }) {
            Text(text = "Login")
        }
        Button(onClick = {
            navController.navigate(Screens.SignupScreen.route)
        }) {
            Text(text = "Signup")
        }
    }
}