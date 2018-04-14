package com.jainamj.myapplication.data.preference

interface PrefHelper {

    fun clearAll()

    var isLoggedIn: Boolean
    var fcmId: String

}