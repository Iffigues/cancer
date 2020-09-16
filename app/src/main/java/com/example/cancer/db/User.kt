package com.example.cancer.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?,
    @ColumnInfo(name = "pseudo") val pseudo: String?,
    @ColumnInfo(name = "tel") val tel: String?,
    @ColumnInfo(name = "photo") val photo: String?,
    @ColumnInfo(name = "block") val block: String?
)