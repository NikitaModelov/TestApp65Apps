package ru.modelov.testapp65apps.feature.specialties.list.data.datasource

import retrofit2.Response
import ru.modelov.testapp65apps.feature.specialties.list.data.api.SpecialtiesApi
import ru.modelov.testapp65apps.main.domain.entities.MyResponse

class SpecialtiesRemoteDataSourceImpl(private val api: SpecialtiesApi) :
    SpecialtiesRemoteDataSource {

    override suspend fun getSpecialties(): Response<MyResponse> = api.getSpecialties()
}