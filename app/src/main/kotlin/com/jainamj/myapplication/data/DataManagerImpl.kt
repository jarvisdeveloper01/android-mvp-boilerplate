package com.jainamj.myapplication.data

import com.jainamj.myapplication.App
import com.jainamj.myapplication.data.api.ApiHelper
import com.jainamj.myapplication.data.api.models.git.UserInfo
import com.jainamj.myapplication.data.api.models.liveexams.Container
import com.jainamj.myapplication.data.db.DbHelper
import com.jainamj.myapplication.data.preference.PrefHelper
import com.jainamj.myapplication.di.scopes.AppScope
import io.reactivex.Observable
import javax.inject.Inject

class DataManagerImpl @Inject constructor(
        @AppScope var app: App,
        var mPreferenceHelper: PrefHelper,
        var mApiHelper: ApiHelper,
        var mDBHelper: DbHelper
) : DataManager {
    override fun setUserId(userId: String) {
        mPreferenceHelper.userId = userId
    }

    override fun getUserId(): String? = mPreferenceHelper.userId

    override fun getUserInfo(): Observable<UserInfo>? {
        return mPreferenceHelper.userId?.let { mApiHelper.getUserRepos(it) }
    }

    override fun getBeforeSignupLanguages(): Observable<Container> = mApiHelper.getLanguagesBeforeSignup()
}