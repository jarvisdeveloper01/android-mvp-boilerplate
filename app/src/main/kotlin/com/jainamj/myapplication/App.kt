package com.jainamj.myapplication

import android.app.Application
import com.facebook.stetho.Stetho
import com.google.firebase.FirebaseApp
import com.tumblr.remember.Remember
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
@HiltAndroidApp()
class App : Application() {


    override fun onCreate() {
        super.onCreate()
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


}
