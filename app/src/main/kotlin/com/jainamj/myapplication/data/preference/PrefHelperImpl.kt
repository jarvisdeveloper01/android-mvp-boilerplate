package com.jainamj.myapplication.data.preference

import com.tumblr.remember.Remember
import javax.inject.Inject

class PrefHelperImpl @Inject constructor() : PrefHelper {

    private val KEY_USER_ID = "KEY_USER_ID"

    override var userId: String?
        get() = Remember.getString(KEY_USER_ID, "jainamjhaveri")
        set(value) {
            Remember.putString(KEY_USER_ID, value)
        }
}