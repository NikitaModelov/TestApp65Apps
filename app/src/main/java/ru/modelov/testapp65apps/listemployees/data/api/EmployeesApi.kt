package ru.modelov.testapp65apps.listemployees.data.api

import retrofit2.Response
import retrofit2.http.GET
import ru.modelov.testapp65apps.main.domain.entities.MyResponse

interface EmployeesApi {

    @GET("testTask.json")
    suspend fun getEmployees(): Response<MyResponse>
}