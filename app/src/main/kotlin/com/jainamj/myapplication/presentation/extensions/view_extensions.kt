@file:JvmName("ViewUtils")

package com.jainamj.myapplication.presentation.extensions

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


fun Context.inflate(@LayoutRes resId: Int, parent: ViewGroup? = null, attachToRoot: Boolean = false): View =
        LayoutInflater.from(this).inflate(resId, parent, false)

fun View.loadDrawable(@DrawableRes drawable: Int) {
    this.background = ContextCompat.getDrawable(context, drawable)
}

fun View.setVisibility(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}