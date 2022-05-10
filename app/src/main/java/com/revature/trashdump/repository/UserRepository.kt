package com.revature.trashdump.repository

import android.app.Application
import com.revature.trashdump.data.User
import com.revature.trashdump.data.UserDao
import com.revature.trashdump.data.UserDatabase

class UserRepository(application: Application) {
    private var userDao: UserDao
    init {
        val database= UserDatabase.getDatabase(application)
        userDao = database.userDao()
    }
    suspend fun insertUser(user: User)
    {
        userDao.insertUser(user)
    }
}