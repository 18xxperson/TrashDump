package com.revature.trashdump.ui

sealed class Screens(val route:String)
{
    object MainScreen: Screens("MainScreen")
    object LoginScreen: Screens("Login")
    object SignupScreen: Screens("Signup")
}
