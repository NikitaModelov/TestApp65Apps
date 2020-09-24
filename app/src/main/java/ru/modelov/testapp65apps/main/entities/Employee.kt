package ru.modelov.testapp65apps.main.entities

import com.google.gson.annotations.SerializedName

typealias Employees = List<Employee>

data class Employee(
    @SerializedName("f_name") var firstName: String,
    @SerializedName("l_name") var lastName: String,
    @SerializedName("birthday") val birthday: String?,
    @SerializedName("avatr_url") val avatarUrl: String?,
    @SerializedName("specialty") val specialty: List<Specialty>
)