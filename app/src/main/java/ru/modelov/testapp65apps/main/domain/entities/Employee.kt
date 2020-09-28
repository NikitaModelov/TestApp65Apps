package ru.modelov.testapp65apps.main.domain.entities

import androidx.room.Entity
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import ru.modelov.testapp65apps.feature.specialties.list.data.database.converter.SpecialtiesConverter
import java.io.Serializable

typealias Employees = List<Employee>

@Entity(tableName = "Employees", primaryKeys = ["firstName", "lastName"])
@TypeConverters(SpecialtiesConverter::class)
data class Employee(
    @SerializedName("f_name") var firstName: String,
    @SerializedName("l_name") var lastName: String,
    @SerializedName("birthday") val birthday: String?,
    @SerializedName("avatr_url") val avatarUrl: String?,

    @SerializedName("specialty") val specialty: Specialties
) : Serializable