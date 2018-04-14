package com.jainamj.myapplication.di.modules

import com.jainamj.myapplication.data.DataManager
import com.jainamj.myapplication.data.DataManagerImpl
import com.jainamj.myapplication.data.api.ApiHelper
import com.jainamj.myapplication.data.api.ApiHelperImpl
import com.jainamj.myapplication.data.db.DbHelper
import com.jainamj.myapplication.data.db.DbHelperImpl
import com.jainamj.myapplication.data.preference.PrefHelper
import com.jainamj.myapplication.data.preference.PrefHelperImpl
import com.jainamj.myapplication.di.scopes.AppScope
import dagger.Module
import dagger.Provides

@Module(includes = [AppContextModule::class])
class AppModule {

    @Provides
    @AppScope
    fun dataManager(dataManagerImpl: DataManagerImpl): DataManager = dataManagerImpl

    @Provides
    @AppScope
    fun preferenceHelper(prefHelperImpl: PrefHelperImpl): PrefHelper = prefHelperImpl

    @Provides
    @AppScope
    fun apiHelper(apiHelperImpl: ApiHelperImpl): ApiHelper = apiHelperImpl

    @Provides
    @AppScope
    fun dbHelper(dbHelperImpl: DbHelperImpl): DbHelper = dbHelperImpl

}