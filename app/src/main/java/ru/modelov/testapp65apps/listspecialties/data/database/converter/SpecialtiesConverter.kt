package ru.modelov.testapp65apps.listspecialties.data.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.modelov.testapp65apps.main.entities.Specialties
import java.lang.reflect.Type


class SpecialtiesConverter {

    @TypeConverter
    fun fromSpecialties(specialties: Specialties): String {
        val gson = Gson()
        return gson.toJson(specialties)
    }

    @TypeConverter
    fun toSpecialties(specialties: String): Specialties {
        val listType: Type = object : TypeToken<Specialties>() {}.type
        return Gson().fromJson(specialties, listType)
    }
}