package ru.modelov.testapp65apps.main.entities

import com.google.gson.annotations.SerializedName

data class Specialty (
    @SerializedName("specialty_id") val specialtyId : Int,
    @SerializedName("name") val name : String
)