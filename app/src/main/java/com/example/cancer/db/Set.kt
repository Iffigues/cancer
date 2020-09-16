package com.example.cancer.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Set(
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "color_header") val color: String?,
    @ColumnInfo(name = "lang") val lang: String?
)