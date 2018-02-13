package com.jainamj.myapplication.data

import com.jainamj.myapplication.App
import com.jainamj.myapplication.data.api.ApiHelper
import com.jainamj.myapplication.data.db.DatabaseHelper
import com.jainamj.myapplication.data.preference.PreferenceHelper
import com.jainamj.myapplication.di.qualifiers.AppContext
import javax.inject.Inject

class AppDataManager @Inject constructor(
        @AppContext var context: App,
        var mPreferenceHelper: PreferenceHelper,
        var mApiHelper: ApiHelper,
        var mDBHelper: DatabaseHelper
) : DataManager