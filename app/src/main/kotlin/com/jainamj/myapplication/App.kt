package com.jainamj.myapplication

import android.support.multidex.MultiDexApplication
import com.crashlytics.android.Crashlytics
import com.facebook.stetho.Stetho
import com.google.firebase.FirebaseApp
import com.jainamj.myapplication.di.components.AppComponent
import com.jainamj.myapplication.di.components.DaggerAppComponent
import com.jainamj.myapplication.di.modules.AppContextModule
import com.jainamj.myapplication.util.NotificationUtils
import com.tumblr.remember.Remember
import io.fabric.sdk.android.Fabric
import net.danlew.android.joda.JodaTimeAndroid
import timber.log.Timber

class App : MultiDexApplication() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
        initRemember()
        initBuildTypeData()
        initJodaTime()
        initFirebase()
        initNotificationUtils()
    }

    private fun initNotificationUtils() {
        NotificationUtils(appComponent.appContext())
    }

    private fun initJodaTime() = JodaTimeAndroid.init(appComponent.appContext())

    private fun initBuildTypeData() {
        when (BuildConfig.BUILD_TYPE) {
            "debug" -> {
                plantTimber()
                initStetho()
            }
            "staging" -> {
                plantTimber()
                initStetho()
                initCrashlytics()
            }
            "release" -> {
                initStetho()
                initCrashlytics()
            }
        }
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
                .appContextModule(AppContextModule(this))
                .build()
        appComponent.inject(this)
    }

    private fun initRemember() = Remember.init(appComponent.appContext(), getString(R.string.app_name))

    private fun initStetho() = Stetho.initializeWithDefaults(appComponent.appContext())

    private fun initCrashlytics() = Fabric.with(appComponent.appContext(), Crashlytics())

    private fun plantTimber() {
        Timber.uprootAll()
        Timber.plant(Timber.DebugTree())
    }

    private fun initFirebase() = FirebaseApp.initializeApp(this)


}
