package com.jainamj.myapplication.data

import com.jainamj.myapplication.data.api.models.git.Follower
import com.jainamj.myapplication.data.api.models.git.UserInfo
import com.jainamj.myapplication.data.api.models.liveexams.Container
import com.jainamj.myapplication.data.db.repository.users.User
import io.reactivex.Observable

interface DataManager {
    fun setUserId(userId: String)
    fun getUserId(): String?
    fun getUserInfo(username: String): Observable<UserInfo>
    fun getUserFollowers(username: String): Observable<List<Follower>>
    fun getBeforeSignupLanguages(): Observable<Container>
    fun insertUserToDb(user: User): Observable<Int>
}