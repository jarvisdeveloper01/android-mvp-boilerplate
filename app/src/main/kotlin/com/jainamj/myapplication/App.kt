package com.jainamj.myapplication

import androidx.multidex.MultiDexApplication
import com.facebook.stetho.Stetho
import com.google.firebase.FirebaseApp
import com.jainamj.myapplication.di.components.AppComponent
import com.jainamj.myapplication.di.components.DaggerAppComponent
import com.jainamj.myapplication.di.modules.AppContextModule
import com.tumblr.remember.Remember
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
//        NotificationUtils(appComponent.context())
    }

    private fun initJodaTime() {
//        JodaTimeAndroid.init(appComponent.context())
    }

    private fun initBuildTypeData() {
        when (BuildConfig.BUILD_TYPE) {
            "debug" -> {
                plantTimber()
                initStetho()
            }
            "staging" -> {
                plantTimber()
                initStetho()
            }
            "release" -> {
                initStetho()
            }
        }
    }

    private fun initRemember(): Remember? {
        return Remember.init(applicationContext, getString(R.string.app_name))
    }

    private fun initStetho() {
        Stetho.initializeWithDefaults(applicationContext)
    }


    private fun plantTimber() {
        Timber.uprootAll()
        Timber.plant(Timber.DebugTree())
    }

    private fun initFirebase() {
        FirebaseApp.initializeApp(this)
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
                .appContextModule(AppContextModule(this))
                .build()
        appComponent.inject(this)
    }


}
