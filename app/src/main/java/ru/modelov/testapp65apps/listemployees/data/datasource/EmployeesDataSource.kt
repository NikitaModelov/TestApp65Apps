package ru.modelov.testapp65apps.listemployees.data.datasource

import retrofit2.Response
import ru.modelov.testapp65apps.main.entities.MyResponse

interface EmployeesDataSource {
    suspend fun getEmployees(): Response<MyResponse>
}