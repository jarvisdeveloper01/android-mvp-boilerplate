package com.jainamj.myapplication.presentation.extensions

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText


fun Context.inflate(@LayoutRes resId: Int, parent: ViewGroup? = null, attachToRoot: Boolean = false): View =
        LayoutInflater.from(this).inflate(resId, parent, false)

fun View.loadDrawable(@DrawableRes drawable: Int) {
    background = ContextCompat.getDrawable(context, drawable)
}

fun View.setVisibility(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

fun View.setViewGone() {
    visibility = View.GONE
}

fun View.setViewVisible() {
    visibility = View.VISIBLE
}

fun EditText.afterTextChanged(afterTextChanged: (String?) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}
