package ru.modelov.testapp65apps.listspecialties.data.repository

import ru.modelov.testapp65apps.listspecialties.data.datasource.SpecialtiesLocalDataSource
import ru.modelov.testapp65apps.listspecialties.data.datasource.SpecialtiesRemoteDataSource
import ru.modelov.testapp65apps.listspecialties.domain.repository.SpecialtiesRepository
import ru.modelov.testapp65apps.main.domain.entities.Specialties
import ru.modelov.testapp65apps.main.domain.entities.Specialty
import ru.modelov.testapp65apps.main.network.Result
import ru.modelov.testapp65apps.main.network.safeApiCall
import ru.modelov.testapp65apps.main.network.safeDatabaseCall
import ru.modelov.testapp65apps.main.utils.wrapper.getSpecialties

class SpecialtiesRepositoryImpl(
    private val remoteDataSource: SpecialtiesRemoteDataSource,
    private val localDataSource: SpecialtiesLocalDataSource
) : SpecialtiesRepository {

    override suspend fun getSpecialties(): Result<Specialties> {
        return when (val localResponse = safeDatabaseCall { localDataSource.fetchSpecialties() }) {
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
    }

    override suspend fun insertSpecialties(specialties: Specialties) {
        safeDatabaseCall {
            localDataSource.insertSpecialties(specialties)
        }
    }

    private suspend fun getRemoteSpecialties(): Result<Specialties> {
        return when (val response = safeApiCall { remoteDataSource.getSpecialties() }) {
            is Result.Success -> {
                insertSpecialties(response.data.getSpecialties())
                Result.Success(response.data.getSpecialties())
            }
            is Result.Error -> Result.Error(response.exception)
        }
    }

    /***
     * Для тетсирования списка
     */
    private fun addTestSpecialty(count: Int, specialties: Specialties): Specialties {
        val test = specialties.toMutableList()
        for (i in 1..count) {
            test.add(Specialty(System.currentTimeMillis(), "Специальность $i"))
        }
        return test.toList()
    }
}