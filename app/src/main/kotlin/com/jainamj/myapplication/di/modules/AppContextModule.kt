package com.jainamj.myapplication.di.modules

import android.content.Context
import com.jainamj.myapplication.di.qualifiers.AppContext
import com.jainamj.myapplication.di.scopes.AppScope
import dagger.Module
import dagger.Provides

@Module
class AppContextModule(private val context: Context) {

    @Provides
    @AppContext
    @AppScope
    fun context(): Context = context.applicationContext

}