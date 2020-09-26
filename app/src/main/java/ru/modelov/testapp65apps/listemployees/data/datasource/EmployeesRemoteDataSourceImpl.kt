package ru.modelov.testapp65apps.listemployees.data.datasource

import retrofit2.Response
import ru.modelov.testapp65apps.listemployees.data.api.EmployeesApi
import ru.modelov.testapp65apps.main.domain.entities.MyResponse

class EmployeesRemoteDataSourceImpl(private val api: EmployeesApi) : EmployeesRemoteDataSource {

    override suspend fun getEmployees(): Response<MyResponse> = api.getEmployees()
}