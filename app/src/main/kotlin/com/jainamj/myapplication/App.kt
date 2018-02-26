package com.jainamj.myapplication

import android.support.multidex.MultiDexApplication
import com.crashlytics.android.Crashlytics
import com.facebook.stetho.Stetho
import com.jainamj.myapplication.di.components.AppComponent
import com.jainamj.myapplication.di.components.DaggerAppComponent
import com.jainamj.myapplication.di.modules.AppContextModule
import com.tumblr.remember.Remember
import io.fabric.sdk.android.Fabric
import timber.log.Timber

class App : MultiDexApplication() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
        initRemeber()
        initBuildTypeData()
    }

    private fun initBuildTypeData() {
        when (BuildConfig.BUILD_TYPE) {
            "debug" -> {
                plantTimber()
                initStetho()
            }
            "staging" -> {
                plantTimber()
                initCrashlytics()
                initStetho()
            }
            "release" -> {
                initCrashlytics()
                initStetho()
            }
        }
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
                .appContextModule(AppContextModule(this))
                .build()
        appComponent.inject(this)
    }

    private fun initRemeber() = Remember.init(appComponent.appContext(), getString(R.string.app_name))

    private fun initStetho() = Stetho.initializeWithDefaults(appComponent.appContext())
//            Stetho.initialize(Stetho.newInitializerBuilder(appComponent.appContext())
//                    .enableDumpapp(Stetho.defaultDumperPluginsProvider(appComponent.appContext()))
//                    .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(appComponent.appContext()))
//                    .build())

    private fun initCrashlytics() = Fabric.with(appComponent.appContext(), Crashlytics())

    private fun plantTimber() {
        Timber.uprootAll()
        Timber.plant(Timber.DebugTree())
    }


}
