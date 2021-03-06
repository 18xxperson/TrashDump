package com.revature.trashdump.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM Users WHERE username = :username")
    fun findUser(username:String):LiveData<User>
}