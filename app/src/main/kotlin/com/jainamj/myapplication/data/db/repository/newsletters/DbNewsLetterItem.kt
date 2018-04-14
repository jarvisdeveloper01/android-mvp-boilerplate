package com.jainamj.myapplication.data.db.repository.newsletters

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "newsLetter")
data class DbNewsLetterItem(@PrimaryKey
                            @ColumnInfo(name = "newsLetterId")
                            var newsLetterId: Int? = -1,
                            @ColumnInfo(name = "newsLetterName")
                            var newsLetterName: String? = "")
