package com.jainamj.myapplication.base.network

import android.content.Context
import android.net.ConnectivityManager

object ConnectivityUtils {
    fun isConnectedToInternet(context: Context): Boolean {
        val cm = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val ni = cm.activeNetworkInfo
        return ni != null && ni.isConnected && ni.isAvailable
    }
}