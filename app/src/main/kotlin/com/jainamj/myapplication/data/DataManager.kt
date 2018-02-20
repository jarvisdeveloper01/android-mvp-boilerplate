package com.jainamj.myapplication.data

import com.jainamj.myapplication.data.api.models.git.UserInfo
import com.jainamj.myapplication.data.api.models.liveexams.Container
import io.reactivex.Observable

interface DataManager {
    fun setUserId(userId: String)
    fun getUserId(): String?
    fun getUserInfo(username: String): Observable<UserInfo>?
    fun getBeforeSignupLanguages(): Observable<Container>
}