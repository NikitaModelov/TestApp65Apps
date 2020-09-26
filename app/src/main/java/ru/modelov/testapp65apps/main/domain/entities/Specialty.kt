package ru.modelov.testapp65apps.main.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

typealias Specialties = List<Specialty>

@Entity(tableName = "Specialty")
data class Specialty(
    @PrimaryKey
    @SerializedName("specialty_id")
    val specialtyId: Long,

    @SerializedName("name")
    val name: String
) : Serializable