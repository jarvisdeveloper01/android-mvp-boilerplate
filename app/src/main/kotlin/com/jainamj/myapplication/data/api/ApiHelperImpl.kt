package com.jainamj.myapplication.data.api

import com.jainamj.myapplication.data.api.models.login.Login
import io.reactivex.Observable
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(var myAppService: MyAppService) : ApiHelper {

    override fun login(userName: String, password: String): Observable<Login> =
            myAppService.login(userName, password)

}