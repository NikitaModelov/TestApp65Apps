package ru.modelov.testapp65apps.feature.employee.listemployees.data.datasource

import retrofit2.Response
import ru.modelov.testapp65apps.main.domain.entities.MyResponse

interface EmployeesRemoteDataSource {
    suspend fun getEmployees(): Response<MyResponse>
}