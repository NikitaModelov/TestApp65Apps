package ru.modelov.testapp65apps.listspecialties.data.repository

import ru.modelov.testapp65apps.listspecialties.data.datasource.SpecialtiesDataSource
import ru.modelov.testapp65apps.listspecialties.domain.repository.SpecialtiesRepository
import ru.modelov.testapp65apps.main.entities.Specialties
import ru.modelov.testapp65apps.main.entities.Specialty
import ru.modelov.testapp65apps.main.network.Result
import ru.modelov.testapp65apps.main.network.safeApiCall
import ru.modelov.testapp65apps.main.utils.wrapper.getSpecialties

class SpecialtiesRepositoryImpl(
    private val dataSource: SpecialtiesDataSource
) : SpecialtiesRepository {

    override suspend fun getSpecialties(): Result<Specialties> =
        when (val response = safeApiCall { dataSource.getSpecialties() }) {
            is Result.Success -> Result.Success(
                addTestSpecialty(
                    10,
                    response.data.getSpecialties()
                )
            )
            is Result.Error -> Result.Error(response.exception)
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