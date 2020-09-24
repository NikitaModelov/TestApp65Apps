package ru.modelov.testapp65apps.listspecialties.data.datasource

import retrofit2.Response
import ru.modelov.testapp65apps.listspecialties.data.api.SpecialtiesApi
import ru.modelov.testapp65apps.main.entities.MyResponse

class SpecialtiesRemoteDataSource(private val api: SpecialtiesApi) : SpecialtiesDataSource {

    override suspend fun getSpecialties(): Response<MyResponse> = api.getSpecialties()
}