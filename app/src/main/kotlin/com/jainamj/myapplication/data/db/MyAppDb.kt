package com.jainamj.myapplication.data.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.jainamj.myapplication.AppConstants
import com.jainamj.myapplication.data.db.repository.newsletters.DbNewsLetterItem
import com.jainamj.myapplication.data.db.repository.newsletters.NewsLetterDao

@Database(entities = [DbNewsLetterItem::class], version = AppConstants.DB_VERSION,exportSchema = false)
abstract class MyAppDb : RoomDatabase() {
    abstract fun newsLetterDao(): NewsLetterDao
}