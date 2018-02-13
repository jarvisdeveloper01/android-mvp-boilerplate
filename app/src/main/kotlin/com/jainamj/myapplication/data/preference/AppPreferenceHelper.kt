package com.jainamj.myapplication.data.preference

import com.tumblr.remember.Remember

class AppPreferenceHelper : PreferenceHelper {

    private val KEY_USER_ID = "KEY_USER_ID"

    override var userId: String?
        get() = Remember.getString(KEY_USER_ID, null)
        set(value) {
            Remember.putString(KEY_USER_ID, value)
        }
}