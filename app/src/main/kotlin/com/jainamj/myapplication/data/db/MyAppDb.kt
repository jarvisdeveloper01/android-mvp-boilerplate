package com.jainamj.myapplication.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.jainamj.myapplication.AppConstants
import com.jainamj.myapplication.data.db.repository.newsletters.DbNewsLetterItem
import com.jainamj.myapplication.data.db.repository.newsletters.NewsLetterDao

@Database(entities = [DbNewsLetterItem::class], version = AppConstants.DB_VERSION)
abstract class MyAppDb : RoomDatabase() {
    abstract fun newsLetterDao(): NewsLetterDao
}