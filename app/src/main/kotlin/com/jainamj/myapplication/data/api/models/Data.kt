package com.jainamj.myapplication.data.api.models

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
open class Data(
        @field:SerializedName("ActionMessage")
        val actionMessage: String? = null,

        @field:SerializedName("ActionStatus")
        val actionStatus: Boolean? = null
)