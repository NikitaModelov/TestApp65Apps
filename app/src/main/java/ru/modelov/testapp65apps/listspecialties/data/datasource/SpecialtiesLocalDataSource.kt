package ru.modelov.testapp65apps.listspecialties.data.datasource

import ru.modelov.testapp65apps.main.entities.Specialties

interface SpecialtiesLocalDataSource {

    suspend fun fetchSpecialties(): Specialties
    suspend fun insertSpecialties(specialties: Specialties)
}