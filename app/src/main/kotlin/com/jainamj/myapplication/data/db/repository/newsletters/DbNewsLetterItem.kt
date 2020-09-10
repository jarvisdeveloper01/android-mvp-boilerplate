package com.jainamj.myapplication.data.db.repository.newsletters


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "newsLetter")
data class DbNewsLetterItem(@PrimaryKey
                            @ColumnInfo(name = "newsLetterId")
                            var newsLetterId: Int? = -1,
                            @ColumnInfo(name = "newsLetterName")
                            var newsLetterName: String? = "")
