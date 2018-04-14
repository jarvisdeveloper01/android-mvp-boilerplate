package com.jainamj.myapplication.data.api

import com.jainamj.myapplication.data.api.models.login.Login
import io.reactivex.Observable
import retrofit2.http.POST

interface MyAppService {

    @POST("users/{username}/followers")
    fun login(userName: String, password: String): Observable<Login>

}