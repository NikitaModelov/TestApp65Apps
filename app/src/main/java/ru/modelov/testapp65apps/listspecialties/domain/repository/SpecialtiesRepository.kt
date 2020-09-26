package ru.modelov.testapp65apps.listspecialties.domain.repository

import ru.modelov.testapp65apps.main.domain.entities.Specialties
import ru.modelov.testapp65apps.main.network.Result

interface SpecialtiesRepository {

    suspend fun getSpecialties(): Result<Specialties>
    suspend fun insertSpecialties(specialties: Specialties)
}