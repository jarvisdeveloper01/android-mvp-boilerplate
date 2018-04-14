package com.jainamj.myapplication.data.preference

import com.tumblr.remember.Remember
import javax.inject.Inject

class PrefHelperImpl @Inject constructor() : PrefHelper {

    private val KEY_IS_LOGGEDIN: String = "KEY_IS_LOGGEDIN"
    private val KEY_FCM_ID: String = "KEY_FCM_ID"

    override fun clearAll() = Remember.clear()

    override var isLoggedIn: Boolean
        get() = Remember.getBoolean(KEY_IS_LOGGEDIN, false)
        set(value) {
            Remember.putBoolean(KEY_IS_LOGGEDIN, value)
        }

    override var fcmId: String
        get() = Remember.getString(KEY_FCM_ID, "")
        set(value) {
            Remember.putString(KEY_FCM_ID, value)
        }

}