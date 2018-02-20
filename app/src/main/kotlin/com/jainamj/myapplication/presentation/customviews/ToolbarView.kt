package com.jainamj.myapplication.presentation.customviews

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.annotation.StringRes
import android.util.AttributeSet
import android.widget.FrameLayout
import com.jainamj.myapplication.R
import com.jainamj.myapplication.presentation.extensions.inflate
import kotlinx.android.synthetic.main.view_toolbar.view.*

class ToolbarView : FrameLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    init {
        addView(context.inflate(R.layout.view_toolbar))
    }

    fun setBackBtnListener(listener: (() -> Any)) = btnBack.setOnClickListener { listener.invoke() }

    fun setToolbarTitle(@StringRes textRes: Int) {
        tvText.text = context.getString(textRes)
    }

}