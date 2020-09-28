package ru.modelov.testapp65apps.feature.specialties.list.data.repository

import ru.modelov.testapp65apps.feature.specialties.list.data.datasource.SpecialtiesLocalDataSource
import ru.modelov.testapp65apps.feature.specialties.list.data.datasource.SpecialtiesRemoteDataSource
import ru.modelov.testapp65apps.feature.specialties.list.domain.repository.SpecialtiesRepository
import ru.modelov.testapp65apps.main.domain.entities.Specialties
import ru.modelov.testapp65apps.main.network.Result
import ru.modelov.testapp65apps.main.network.safeApiCall
import ru.modelov.testapp65apps.main.network.safeDatabaseCall
import ru.modelov.testapp65apps.main.utils.wrapper.getSpecialties

class SpecialtiesRepositoryImpl(
    private val remoteDataSource: SpecialtiesRemoteDataSource,
    private val localDataSource: SpecialtiesLocalDataSource
) : SpecialtiesRepository {

    override suspend fun getSpecialties(): Result<Specialties> =
        when (val localResponse = safeDatabaseCall { localDataSource.fetchSpecialties() }) {
            is Result.Success -> {
                if (localResponse.data.isEmpty()) {
                    getRemoteSpecialties()
                } else {
                    localResponse
                }
            }
            is Result.Error -> {
                getRemoteSpecialties()
            }
        }


    private suspend fun insertSpecialties(specialties: Specialties) {
        safeDatabaseCall {
            localDataSource.insertSpecialties(specialties)
        }
    }

    private suspend fun getRemoteSpecialties(): Result<Specialties> =
        when (val response = safeApiCall { remoteDataSource.getSpecialties() }) {
            is Result.Success -> {
                insertSpecialties(response.data.getSpecialties())
                Result.Success(response.data.getSpecialties())
            }
            is Result.Error -> Result.Error(response.exception)
        }
}