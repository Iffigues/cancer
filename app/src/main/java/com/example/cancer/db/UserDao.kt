package com.example.cancer.db

import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:Id) LIMIT 1")
    fun loadById(Id: Int): User

    @Query("SELECT * FROM user WHERE tel LIKE :pseudo LIMIT 1")
    fun findByName(pseudo: String): User

    @Query("INSERT INTO user (first_name, last_name, tel,pseudo, photo, block) VALUES (:fn, :ln, :phone, :ps,:em, 'non')")
    fun insertRAll(fn: String, ln: String, phone: String, ps: String, em: String): Long

    @Query("UPDATE `user` SET tel = :tel WHERE uid = :id")
    fun changeTel(tel: String, id: Int): Int

    @Query("UPDATE `user` SET first_name = :tel WHERE uid = :id")
    fun changeFn(tel: String, id: Int): Int

    @Query("UPDATE `user` SET last_name = :tel WHERE uid = :id")
    fun changeLn(tel: String, id: Int): Int

    @Query("UPDATE `user` SET pseudo = :tel WHERE uid = :id")
    fun changePs(tel: String, id: Int): Int

    @Query("UPDATE `user` SET photo = :tel WHERE uid = :id")
    fun changeEm(tel: String, id: Int): Int

    @Insert
    fun insertAll(vararg users: User)

    @Update
    suspend fun updateUsers(vararg users: User)

    @Delete
    fun delete(user: User)
}