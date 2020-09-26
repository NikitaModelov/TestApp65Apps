package ru.modelov.testapp65apps.main.domain.entities

import com.google.gson.annotations.SerializedName

data class MyResponse (
    @SerializedName("response") val response: Employees
)