package com.revature.trashdump.data

import androidx.room.Insert
import androidx.room.Query

interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM Users WHERE username = :username")
    fun findUser(username:String)
}