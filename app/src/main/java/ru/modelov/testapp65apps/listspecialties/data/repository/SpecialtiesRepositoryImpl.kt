package ru.modelov.testapp65apps.listspecialties.data.repository

import ru.modelov.testapp65apps.listspecialties.data.datasource.SpecialtiesDataSource
import ru.modelov.testapp65apps.listspecialties.domain.repository.SpecialtiesRepository
import ru.modelov.testapp65apps.main.entities.MyResponse
import ru.modelov.testapp65apps.main.network.Result
import ru.modelov.testapp65apps.main.network.safeApiCall

class SpecialtiesRepositoryImpl(
    private val dataSource: SpecialtiesDataSource
) : SpecialtiesRepository {

    override suspend fun getSpecialties(): Result<MyResponse> = safeApiCall(
        call = { dataSource.getSpecialties() }
    )
}