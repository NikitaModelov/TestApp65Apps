package ru.modelov.testapp65apps.feature.specialties.list.data.datasource

import ru.modelov.testapp65apps.main.domain.entities.Specialties

interface SpecialtiesLocalDataSource {

    suspend fun fetchSpecialties(): Specialties
    suspend fun insertSpecialties(specialties: Specialties)
}