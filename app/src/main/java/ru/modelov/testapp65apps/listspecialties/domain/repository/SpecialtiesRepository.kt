package ru.modelov.testapp65apps.listspecialties.domain.repository

import ru.modelov.testapp65apps.main.entities.MyResponse
import ru.modelov.testapp65apps.main.network.Result

interface SpecialtiesRepository {

    suspend fun getSpecialties(): Result<MyResponse>
}