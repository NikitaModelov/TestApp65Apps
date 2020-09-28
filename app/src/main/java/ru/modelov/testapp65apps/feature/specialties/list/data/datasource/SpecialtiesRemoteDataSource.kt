package ru.modelov.testapp65apps.feature.specialties.list.data.datasource

import retrofit2.Response
import ru.modelov.testapp65apps.main.domain.entities.MyResponse

interface SpecialtiesRemoteDataSource {

    suspend fun getSpecialties(): Response<MyResponse>
}