package com.jainamj.myapplication.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions


object ImageLoader {

    //  use fragment or activity if possible instead of context
    fun <T : Context> loadImage(context: T, into: ImageView, path: String) =
            loadImage(context, into, path, -1, -1, false)

    //  use fragment or activity if possible instead of context
    private fun <T : Context> loadImage(context: T, into: ImageView, path: String, width: Int, height: Int, isCirlce: Boolean) {
        var myOptions = RequestOptions()
        myOptions = myOptions.diskCacheStrategy(DiskCacheStrategy.ALL)
        if (width > 0 && height > 0) {
            myOptions = myOptions.override(width, height)
        }
        if (isCirlce) {
            myOptions = myOptions.circleCrop()
        } else {
            myOptions = myOptions.centerCrop()
        }
        Glide.with(context)
                .load(path)
                .apply(myOptions)
                .into(into)
    }

    //use fragment or activity if possible instead of context
    fun <T : Context> loadCircleImage(context: T, into: ImageView, path: String) =
            loadImage(context, into, path, -1, -1, true)
}
