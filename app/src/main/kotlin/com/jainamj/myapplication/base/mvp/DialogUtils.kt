package com.jainamj.myapplication.base.mvp

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.jainamj.myapplication.R

object DialogUtils {

    @SuppressLint("InflateParams")
    fun showLoading(context: Context,
                    message: String = "",
                    isCancelable: Boolean = false): ProgressDialog {
        val progressDialog = ProgressDialog(context)
        progressDialog.show()
        val window = progressDialog.window
        window?.setBackgroundDrawable(ColorDrawable(Color.GRAY))
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.view_loading, null)
        val messageTextView = view.findViewById<TextView>(R.id.loading_message)
        if (TextUtils.isEmpty(message)) {
            messageTextView.visibility = View.GONE
        } else {
            messageTextView.text = message
            messageTextView.visibility = View.VISIBLE
        }
        progressDialog.setContentView(view)
        progressDialog.isIndeterminate = true
        progressDialog.setCancelable(isCancelable)
        progressDialog.setCanceledOnTouchOutside(isCancelable)
        return progressDialog
    }


}
