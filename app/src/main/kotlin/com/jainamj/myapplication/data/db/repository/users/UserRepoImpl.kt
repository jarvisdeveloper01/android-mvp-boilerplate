package com.jainamj.myapplication.data.db.repository.users

import com.jainamj.myapplication.data.db.DbErrorHandler.handleDbError
import io.reactivex.Observable
import javax.inject.Inject

class UserRepoImpl @Inject constructor(var userDao: UserDao) : UserRepo {
    override fun addAllUsers(users: List<User>): Observable<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addUser(user: User): Observable<Long> =
            Observable.fromCallable { userDao.insertUser(user) }
                    .onErrorReturn { error -> handleDbError(error) }

    override fun updateUser(user: User): Observable<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteUser(user: User): Observable<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findUser(id: Long): Observable<User> =
            Observable.fromCallable { userDao.findUser(id) }

    override fun getAllUsers(): Observable<List<User>> =
            Observable.fromCallable { userDao.getAllUsers() }
}