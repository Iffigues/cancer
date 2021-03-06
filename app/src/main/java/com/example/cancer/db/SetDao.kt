package com.example.cancer.db

import androidx.room.*

@Dao
interface SetDao {
    @Query("SELECT * FROM `set`")
    fun getAll(): List<Set>


    @Query("UPDATE `set` SET lang = :lang WHERE uid = 1")
    fun changeLang(lang: String): Int

    @Query("UPDATE `set` SET color_header = :color WHERE uid = 1")
    fun changeColor(color: String): Int

    @Query("SELECT * FROM `set` WHERE uid IN (:setIds)")
    fun loadAllByIds(setIds: IntArray): List<Set>

    @Query("SELECT * FROM `set` WHERE uid = 1 LIMIT 1")
    fun findByName(): Set

    @Insert
    fun insertAll(vararg sets: Set)

    @Update
    suspend fun updateUsers(vararg sets: Set)

    @Delete
    fun delete(set: Set)

}
