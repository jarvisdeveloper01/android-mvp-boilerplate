package com.jainamj.myapplication.data.db.repository.users

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class User(@ColumnInfo(name = "id")
                @PrimaryKey
                var id: Int? = -1,
                @ColumnInfo(name = "name")
                var name: String? = "",
                @ColumnInfo(name = "repos")
                var reposUrl: String? = "",
                @ColumnInfo(name = "avatarUrl")
                var avatarUrl: String? = "")