package com.jainamj.myapplication.presentation.customviews

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.StringRes
import com.jainamj.myapplication.R
import com.jainamj.myapplication.presentation.extensions.inflate
import com.jainamj.myapplication.presentation.extensions.setVisibility
import kotlinx.android.synthetic.main.view_toolbar.view.*

class ToolbarView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        addView(context.inflate(R.layout.view_toolbar))
    }

    fun setBackBtnListener(listener: (() -> Any)) = btnBack.setOnClickListener { listener.invoke() }

    fun setToolbarTitle(@StringRes textRes: Int) {
        tvText.text = context.getString(textRes)
    }

    fun setToolbarTitle(text: String) {
        tvText.text = text
    }

    fun setBackBtnVisibilityGone() = btnBack.setVisibility(false)

}