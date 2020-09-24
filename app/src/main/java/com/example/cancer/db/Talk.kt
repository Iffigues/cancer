package com.example.cancer.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Talk(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "message") val message: String,
    @ColumnInfo(name = "who") val who: String,
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "created") var created: Date,
)