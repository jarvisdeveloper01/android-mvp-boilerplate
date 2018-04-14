package com.jainamj.myapplication.util

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.res.Resources
import android.os.Handler
import android.util.DisplayMetrics
import android.view.View

class Utilities {

    companion object {

        /**
         * Executes passed function after specificied delay
         *
         * @param func any function that has be executed after delay
         * @param delayMillis delay after which function needs to be executed
         */
        fun delayCallBack(func: () -> Any?, delayMillis: Long = 300) {
            Handler().postDelayed({
                func()
            }, delayMillis)
        }

        /**
         * Converts dp to pixels
         *
         * @param dpWidth A value in dp (density independent pixels) unit. Which we need to convert into pixels
         * @return int value to represent px equivalent to dp depending on device density
         */
        fun getPxFromDp(dpWidth: Float): Float {
            val metrics = Resources.getSystem().displayMetrics
            return dpWidth * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
        }

        /**
         * used for accordion toggling of a view
         *
         *
         * This method is used in for loop to
         * 1. set all the views except the clicked view as GONE
         * 2. and toggle the visibility of clicked view
         *
         * @param isClickedView true if it the clickedView that needs to be handled, false otherwise
         */
        fun View.toggleVisibility(isClickedView: Boolean) {

            if (isClickedView) {
                animate()
                        .translationX(0f)
                        .alpha(1f)
                        .setDuration(300)
                        .setListener(object : AnimatorListenerAdapter() {

                            override fun onAnimationStart(animation: Animator) {
                                super.onAnimationStart(animation)
                                if (visibility == View.VISIBLE)
                                    toggleVisibility(false)
                                else
                                    visibility = View.VISIBLE

                            }

                        })
            } else {
                animate()
                        .translationX((-width).toFloat())
                        .alpha(0.0f)
                        .setDuration(300)
                        .setListener(object : AnimatorListenerAdapter() {
                            override fun onAnimationEnd(animation: Animator) {
                                super.onAnimationEnd(animation)
                                visibility = View.GONE
                            }
                        })
            }
        }

    }

}