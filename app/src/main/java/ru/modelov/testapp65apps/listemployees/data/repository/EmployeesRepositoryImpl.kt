package ru.modelov.testapp65apps.listemployees.data.repository

import ru.modelov.testapp65apps.listemployees.data.datasource.EmployeesDataSource
import ru.modelov.testapp65apps.listemployees.domain.repository.EmployeesRepository
import ru.modelov.testapp65apps.main.entities.Employees
import ru.modelov.testapp65apps.main.network.Result
import ru.modelov.testapp65apps.main.network.safeApiCall
import ru.modelov.testapp65apps.main.utils.wrapper.getEmployees

class EmployeesRepositoryImpl(private val dataSource: EmployeesDataSource) : EmployeesRepository {

    override suspend fun getEmployees(idSpecialty: Long): Result<Employees> =
        when (val response = safeApiCall { dataSource.getEmployees() }) {
            is Result.Success -> Result.Success(response.data.getEmployees(idSpecialty))
            is Result.Error -> Result.Error(response.exception)
        }
}