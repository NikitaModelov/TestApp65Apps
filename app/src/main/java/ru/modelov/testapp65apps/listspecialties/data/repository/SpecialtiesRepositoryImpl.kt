package ru.modelov.testapp65apps.listspecialties.data.repository

import ru.modelov.testapp65apps.listspecialties.data.datasource.SpecialtiesDataSource
import ru.modelov.testapp65apps.listspecialties.domain.repository.SpecialtiesRepository
import ru.modelov.testapp65apps.main.entities.Specialties
import ru.modelov.testapp65apps.main.network.Result
import ru.modelov.testapp65apps.main.network.safeApiCall
import ru.modelov.testapp65apps.main.utils.wrapper.getSpecialties

class SpecialtiesRepositoryImpl(
    private val dataSource: SpecialtiesDataSource
) : SpecialtiesRepository {

    override suspend fun getSpecialties(): Result<Specialties> =
        when (val response = safeApiCall { dataSource.getSpecialties() }) {
            is Result.Success -> Result.Success(response.data.getSpecialties())
            is Result.Error -> Result.Error(response.exception)
        }
}