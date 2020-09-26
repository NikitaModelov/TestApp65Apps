package ru.modelov.testapp65apps.listspecialties.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.modelov.testapp65apps.main.domain.entities.Specialties

@Dao
interface SpecialtyDao {

    @Query("SELECT * FROM Specialty")
    suspend fun fetchSpecialty(): Specialties

    @Insert
    suspend fun insertAll(specialties: Specialties)
}