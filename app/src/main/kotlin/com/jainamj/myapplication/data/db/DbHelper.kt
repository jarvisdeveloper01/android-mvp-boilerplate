package com.jainamj.myapplication.data.db

import com.jainamj.myapplication.data.db.repository.users.User
import io.reactivex.Observable

interface DbHelper {
    fun addAllUsers(users: List<User>): Observable<Boolean>

    fun addUser(user: User): Observable<Long>

    fun updateUser(user: User): Observable<Boolean>

    fun deleteUser(user: User): Observable<Boolean>

    fun findUser(id: Long): Observable<User>

    fun getAllUsers(): Observable<List<User>>
}