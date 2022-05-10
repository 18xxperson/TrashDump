package com.revature.trashdump.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.revature.trashdump.data.User
import com.revature.trashdump.repository.UserRepository
import com.revature.trashdump.ui.Screens
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {
    private val userRepository=UserRepository(application)
    suspend fun insertUser(user: User,navController: NavController)
    {
        viewModelScope.launch {
            if(!userRepository.insertUser(user))
            {
                navController.navigate(Screens.SignupScreen.route)
            }
        }
    }

    fun findUser(username:String):LiveData<User>
    {
        return userRepository.findUser(username)
    }

}