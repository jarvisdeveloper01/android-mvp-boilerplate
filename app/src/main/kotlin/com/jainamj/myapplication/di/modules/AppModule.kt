package com.jainamj.myapplication.di.modules

import com.jainamj.myapplication.data.DataManager
import com.jainamj.myapplication.data.DataManagerImpl
import com.jainamj.myapplication.data.api.ApiHelper
import com.jainamj.myapplication.data.api.ApiHelperImpl
import com.jainamj.myapplication.data.db.DbHelper
import com.jainamj.myapplication.data.db.DbHelperImpl
import com.jainamj.myapplication.data.preference.PrefHelper
import com.jainamj.myapplication.data.preference.PrefHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@InstallIn(value = [ApplicationComponent::class])
@Module
class AppModule {

    @Provides
    @Singleton
    fun dataManager(dataManagerImpl: DataManagerImpl): DataManager = dataManagerImpl

    @Provides
    @Singleton
    fun preferenceHelper(prefHelperImpl: PrefHelperImpl): PrefHelper = prefHelperImpl

    @Provides
    @Singleton
    fun apiHelper(apiHelperImpl: ApiHelperImpl): ApiHelper = apiHelperImpl

    @Provides
    @Singleton
    fun dbHelper(dbHelperImpl: DbHelperImpl): DbHelper = dbHelperImpl

}