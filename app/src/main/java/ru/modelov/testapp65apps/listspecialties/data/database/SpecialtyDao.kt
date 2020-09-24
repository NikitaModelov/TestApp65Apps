package ru.modelov.testapp65apps.listspecialties.data.database

import androidx.room.Dao
import androidx.room.Query
import ru.modelov.testapp65apps.main.entities.Specialties

@Dao
interface SpecialtyDao {

    @Query("SELECT * FROM Specialty")
    suspend fun fetchSpecialty(): Specialties
}