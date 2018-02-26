package com.jainamj.myapplication.data.db.repository.users

import io.reactivex.Observable


interface UserRepo {

    fun addAllUsers(users: List<User>): Observable<Boolean>

    fun addUser(user: User): Observable<Int>

    fun updateUser(user: User): Observable<Boolean>

    fun deleteUser(user: User): Observable<Boolean>

    fun findUser(id: Long): Observable<User>

    fun getAllUsers(): Observable<List<User>>

}