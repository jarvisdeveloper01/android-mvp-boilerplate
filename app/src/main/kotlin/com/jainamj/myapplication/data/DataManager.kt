package com.jainamj.myapplication.data

import com.jainamj.myapplication.data.api.models.git.UserInfo
import com.jainamj.myapplication.data.api.models.liveexams.Container
import io.reactivex.Observable

interface DataManager {
    fun setUserId(userId: String)
    fun getUserId(): String?
    fun getUserInfo(): Observable<UserInfo>?
    fun getBeforeSignupLanguages(): Observable<Container>
}