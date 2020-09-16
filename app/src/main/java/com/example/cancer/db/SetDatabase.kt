package com.example.cancer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cancer.db.SetDao
import com.example.cancer.db.User

@Database(entities = [Set::class], version = 2)
abstract class SetDatabase : RoomDatabase() {
    abstract fun setDao(): SetDao
}