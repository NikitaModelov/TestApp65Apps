package ru.modelov.testapp65apps.listspecialties.data.datasource

import retrofit2.Response
import ru.modelov.testapp65apps.main.entities.MyResponse

interface SpecialtiesDataSource {

    suspend fun getSpecialties(): Response<MyResponse>
}