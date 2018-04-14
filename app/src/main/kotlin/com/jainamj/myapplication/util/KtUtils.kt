package com.jainamj.myapplication.util

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Handler
import android.view.View


object KtUtils {

    fun delayCallBack(func: () -> Any, time: Long = 300) {
        Handler().postDelayed({
            func()
        }, time)
    }

    private fun toggleVisibility(isClickedView: Boolean, view: View) {

        if (isClickedView) {
            view.animate()
                    .translationX(0f)
                    .alpha(1f)
                    .setDuration(300)
                    .setListener(object : AnimatorListenerAdapter() {

                        override fun onAnimationStart(animation: Animator) {
                            super.onAnimationStart(animation)
                            if (view.visibility == View.VISIBLE)
                                toggleVisibility(false, view)
                            else
                                view.visibility = View.VISIBLE

                        }

                    })
        } else {
            view.animate()
                    .translationX((-view.width).toFloat())
                    .alpha(0.0f)
                    .setDuration(300)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            super.onAnimationEnd(animation)
                            view.visibility = View.GONE
                        }
                    })
        }
    }

}