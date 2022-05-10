package com.revature.trashdump.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class User(
    @PrimaryKey
    var username:String,
    @ColumnInfo
    var password:String
)