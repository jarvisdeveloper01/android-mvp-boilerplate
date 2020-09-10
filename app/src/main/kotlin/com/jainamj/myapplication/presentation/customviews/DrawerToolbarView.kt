package com.jainamj.myapplication.presentation.customviews

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.StringRes
import com.jainamj.myapplication.R
import com.jainamj.myapplication.presentation.extensions.inflate
import kotlinx.android.synthetic.main.view_drawer_toolbar.view.*

class DrawerToolbarView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    init {
        addView(context.inflate(R.layout.view_drawer_toolbar))
    }

    fun setDrawerBtnListener(listener: (() -> Any)) = btnDrawer.setOnClickListener { listener.invoke() }

    fun setToolbarTitle(@StringRes textRes: Int) {
        tvText.text = context.getString(textRes)
    }
}