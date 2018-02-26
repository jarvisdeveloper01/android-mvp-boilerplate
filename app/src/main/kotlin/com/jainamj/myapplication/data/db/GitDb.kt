package com.jainamj.myapplication.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.jainamj.myapplication.AppConstants
import com.jainamj.myapplication.data.db.repository.users.User
import com.jainamj.myapplication.data.db.repository.users.UserDao

@Database(entities = [User::class], version = AppConstants.GIT_DB_VERSION)
abstract class GitDb : RoomDatabase() {
    abstract fun userDao(): UserDao
//    abstract fun followersDao(): FollowersDao
}