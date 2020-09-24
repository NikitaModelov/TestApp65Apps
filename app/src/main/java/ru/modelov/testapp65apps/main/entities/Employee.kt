package ru.modelov.testapp65apps.main.entities

import com.google.gson.annotations.SerializedName

data class Employee (
    @SerializedName("f_name") val firstName : String,
    @SerializedName("l_name") val lastName : String,
    @SerializedName("birthday") val birthday : String?,
    @SerializedName("avatr_url") val avatarUrl : String?,
    @SerializedName("specialty") val specialty : List<Specialty>
)