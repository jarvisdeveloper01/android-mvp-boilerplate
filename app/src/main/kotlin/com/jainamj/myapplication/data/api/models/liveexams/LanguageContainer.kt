package com.jainamj.myapplication.data.api.models.liveexams

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class LanguageContainer(

        @field:SerializedName("Language")
        val languages: List<String> = mutableListOf()
)