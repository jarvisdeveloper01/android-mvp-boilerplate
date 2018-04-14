package com.jainamj.myapplication.data

import com.jainamj.myapplication.data.api.models.login.Login
import com.jainamj.myapplication.data.db.repository.newsletters.DbNewsLetterItem
import io.reactivex.Observable


interface DataManager {
    fun isUserLoggedIn(): Boolean
    fun login(username: String, password: String): Observable<Login>
    fun addNewsLetter(newsLetter: DbNewsLetterItem): Observable<Long>
}