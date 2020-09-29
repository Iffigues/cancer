package com.example.cancer.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TalkDao {
    @Query("SELECT * FROM `talk`")
    fun getAll(): List<Talk>

    @Query("SELECT * FROM `talk` WHERE id LIKE :If  ORDER BY created DESC")
    fun hh(If: Int): List<Talk>

    @Query("INSERT INTO talk (message, who, id, created) VALUES (:fn, :ln, :Id,  date('now')) ")
    fun insertRAll(fn: String, ln: String, Id: Int): Long

    @Insert
    fun insertAll(vararg talks: Talk)


}