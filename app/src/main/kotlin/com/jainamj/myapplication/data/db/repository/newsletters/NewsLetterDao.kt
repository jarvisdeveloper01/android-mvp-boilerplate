package com.jainamj.myapplication.data.db.repository.newsletters

import androidx.room.*

@Dao
interface NewsLetterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllNewsLettertoDb(newsLetter: List<DbNewsLetterItem>): List<Long>

    @Query("SELECT * FROM newsletter")
    fun getAllNewsLetter(): List<DbNewsLetterItem>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertNewsLetter(newsLetter: DbNewsLetterItem): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateNewsLetter(newsLetter: DbNewsLetterItem): Int

    @Delete
    fun deleteNewsLetter(newsLetter: DbNewsLetterItem)
}