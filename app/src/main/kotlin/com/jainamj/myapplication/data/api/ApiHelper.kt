package com.jainamj.myapplication.data.api


import com.jainamj.myapplication.data.api.models.login.Login
import com.jainamj.myapplication.data.db.repository.newsletters.DbNewsLetterItem
import io.reactivex.Observable

interface ApiHelper {

    fun login(userName: String, password: String): Observable<Login>

}