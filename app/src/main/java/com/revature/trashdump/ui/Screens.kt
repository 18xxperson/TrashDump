package com.revature.trashdump.ui

sealed class Screens(val route:String)
{
    object MainScreen: Screens("MainScreen")
    object LoginScreen: Screens("Login")
    object SignupScreen: Screens("Signup")
    object ChooseCompany: Screens("Choose Company")
    object AddCompany: Screens("Add Company")
    object PostList: Screens("Post List")
    object AddPost: Screens("Add Post")
}
