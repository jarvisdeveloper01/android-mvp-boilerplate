package com.jainamj.myapplication.data.db.repository.users

import android.arch.persistence.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Update(onConflict = OnConflictStrategy.ABORT)
    fun insertUser(user: User): Int

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(user: User): Int

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM users WHERE id= :arg0")
    fun findUser(userId: Long): User
}