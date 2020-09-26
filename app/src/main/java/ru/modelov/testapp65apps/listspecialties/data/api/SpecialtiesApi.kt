package ru.modelov.testapp65apps.listspecialties.data.api

import retrofit2.Response
import retrofit2.http.GET
import ru.modelov.testapp65apps.main.domain.entities.MyResponse

interface SpecialtiesApi {

    @GET("testTask.json")
    suspend fun getSpecialties(): Response<MyResponse>
}