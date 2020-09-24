package ru.modelov.testapp65apps.listemployees.data.datasource

import retrofit2.Response
import ru.modelov.testapp65apps.listemployees.data.api.EmployeesApi
import ru.modelov.testapp65apps.main.entities.MyResponse

class EmployeesRemoteDataSource(private val api: EmployeesApi) : EmployeesDataSource {

    override suspend fun getEmployees(): Response<MyResponse> = api.getEmployees()
}