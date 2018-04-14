package com.jainamj.myapplication.data

import com.jainamj.myapplication.data.api.ApiHelper
import com.jainamj.myapplication.data.api.models.login.Login
import com.jainamj.myapplication.data.db.DbHelper
import com.jainamj.myapplication.data.db.repository.newsletters.DbNewsLetterItem
import com.jainamj.myapplication.data.preference.PrefHelper
import io.reactivex.Observable
import javax.inject.Inject

class DataManagerImpl @Inject constructor(
        private var mPreferenceHelper: PrefHelper,
        private var mApiHelper: ApiHelper,
        private var mDBHelper: DbHelper
) : DataManager {

    override fun isUserLoggedIn(): Boolean = mPreferenceHelper.isLoggedIn

    override fun login(username: String, password: String): Observable<Login> =
            mApiHelper.login(username, password)

    override fun addNewsLetter(newsLetter: DbNewsLetterItem): Observable<Long> =
            mDBHelper.addNewsLetter(newsLetter)

}