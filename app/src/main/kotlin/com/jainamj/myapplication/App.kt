package com.jainamj.myapplication

import android.support.multidex.MultiDexApplication
import com.crashlytics.android.Crashlytics
import com.facebook.stetho.Stetho
import com.tumblr.remember.Remember
import io.fabric.sdk.android.Fabric
import timber.log.Timber

class App : MultiDexApplication() {
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

    private fun initRemeber() {
        Remember.init(this, getString(R.string.app_name))
    }

    private fun initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build())
    }

    private fun initCrashlytics() {
        Fabric.with(this, Crashlytics())
    }

    private fun plantTimber() {
        Timber.uprootAll()
        Timber.plant(Timber.DebugTree())
    }

    private fun initializeDagger() {

    }


}
