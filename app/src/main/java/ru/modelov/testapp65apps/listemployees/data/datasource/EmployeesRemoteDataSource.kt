package ru.modelov.testapp65apps.listemployees.data.datasource

import retrofit2.Response
import ru.modelov.testapp65apps.main.domain.entities.MyResponse

interface EmployeesRemoteDataSource {
    suspend fun getEmployees(): Response<MyResponse>
}