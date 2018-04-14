package com.jainamj.myapplication.data.api.models

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Response<out T : Data>(

        @field:SerializedName("Status")
        val status: Boolean? = null,

        @field:SerializedName("Message")
        val message: String? = null,

        @field:SerializedName("Data")
        val data: T
)
