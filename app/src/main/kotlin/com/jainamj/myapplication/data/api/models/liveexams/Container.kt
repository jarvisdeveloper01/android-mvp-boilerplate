package com.jainamj.myapplication.data.api.models.liveexams

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Container(

        @field:SerializedName("response")
        val languageContainer: LanguageContainer,

        @field:SerializedName("success")
        val success: String? = null
)