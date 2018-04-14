package com.jainamj.myapplication.data.api.models.login

import com.google.gson.annotations.SerializedName
import com.jainamj.myapplication.data.api.models.Data
import javax.annotation.Generated


@Generated("com.robohorse.robopojogenerator")
data class Login(

        @field:SerializedName("ZoneName")
        val zoneName: String? = null,

        @field:SerializedName("AuthenticationToken")
        val authenticationToken: String? = null,

        @field:SerializedName("MISMemberID")
        val mISMemberID: Int? = null,

        @field:SerializedName("ZoneId")
        val zoneId: Int? = null,

        @field:SerializedName("MembershipNumber")
        val membershipNumber: String? = null,

        @field:SerializedName("IsMulaqat")
        val isMulaqat: Int? = null

) : Data()