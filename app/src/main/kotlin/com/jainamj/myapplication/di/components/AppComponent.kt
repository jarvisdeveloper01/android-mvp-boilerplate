package com.jainamj.myapplication.di.components

import android.content.Context
import com.jainamj.myapplication.App
import com.jainamj.myapplication.data.DataManager
import com.jainamj.myapplication.di.modules.AppModule
import com.jainamj.myapplication.di.modules.NetworkModule
import com.jainamj.myapplication.di.qualifiers.AppContext
import com.jainamj.myapplication.di.scopes.AppScope
import dagger.Component

@AppScope
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    //exposed to sub graph
    @AppContext
    fun appContext(): Context

    val dataManager: DataManager

    fun inject(app: App)
}