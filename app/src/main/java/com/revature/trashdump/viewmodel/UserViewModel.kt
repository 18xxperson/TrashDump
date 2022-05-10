package com.revature.trashdump.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.revature.trashdump.data.User
import com.revature.trashdump.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {
    private val userRepository=UserRepository(application)
    suspend fun insertUser(user: User)
    {
        viewModelScope.launch {
            userRepository.insertUser(user)
        }
    }

}