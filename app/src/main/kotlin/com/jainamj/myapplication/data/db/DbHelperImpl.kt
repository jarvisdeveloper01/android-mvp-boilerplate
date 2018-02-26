package com.jainamj.myapplication.data.db

import com.jainamj.myapplication.data.db.repository.users.User
import com.jainamj.myapplication.data.db.repository.users.UserRepo
import io.reactivex.Observable
import javax.inject.Inject


class DbHelperImpl @Inject constructor(var userRepo: UserRepo) : DbHelper {
    override fun addAllUsers(users: List<User>): Observable<Boolean> = userRepo.addAllUsers(users)

    override fun addUser(user: User): Observable<Int> = userRepo.addUser(user)

    override fun updateUser(user: User): Observable<Boolean> = userRepo.updateUser(user)

    override fun deleteUser(user: User): Observable<Boolean> = userRepo.deleteUser(user)

    override fun findUser(id: Long): Observable<User> = userRepo.findUser(id)

    override fun getAllUsers(): Observable<List<User>> = userRepo.getAllUsers()
}