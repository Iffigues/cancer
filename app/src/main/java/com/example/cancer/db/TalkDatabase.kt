package com.example.cancer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@TypeConverters(Converter.Converters::class)
@Database(entities = [Talk::class], version = 1)
abstract class TalkDatabase : RoomDatabase() {
    abstract fun talkDao(): TalkDao
}