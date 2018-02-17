package com.jainamj.myapplication.data.api

import com.jainamj.myapplication.data.api.models.git.UserInfo
import com.jainamj.myapplication.data.api.models.liveexams.Container
import io.reactivex.Observable

interface ApiHelper {
    fun getUserRepos(username: String): Observable<UserInfo>
    fun getLanguagesBeforeSignup(): Observable<Container>
}