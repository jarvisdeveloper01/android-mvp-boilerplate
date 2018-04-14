package com.jainamj.myapplication.base.network

import com.google.gson.annotations.SerializedName

internal class MyAppWrappedError(
        @field:SerializedName("Message")
        val message: String,

        @field:SerializedName("Status")
        val status: Boolean)
