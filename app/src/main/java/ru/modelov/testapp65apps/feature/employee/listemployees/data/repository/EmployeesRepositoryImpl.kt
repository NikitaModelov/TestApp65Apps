package ru.modelov.testapp65apps.feature.employee.listemployees.data.repository

import ru.modelov.testapp65apps.feature.employee.listemployees.data.datasource.EmployeesLocalDataSource
import ru.modelov.testapp65apps.feature.employee.listemployees.data.datasource.EmployeesRemoteDataSource
import ru.modelov.testapp65apps.feature.employee.listemployees.domain.repository.EmployeesRepository
import ru.modelov.testapp65apps.main.domain.entities.Employees
import ru.modelov.testapp65apps.main.network.Result
import ru.modelov.testapp65apps.main.network.safeApiCall
import ru.modelov.testapp65apps.main.network.safeDatabaseCall
import ru.modelov.testapp65apps.main.utils.wrapper.getEmployees
import ru.modelov.testapp65apps.main.utils.wrapper.getEmployeesByIdSpecialty

class EmployeesRepositoryImpl(
    private val remoteDataSource: EmployeesRemoteDataSource,
    private val localDataSource: EmployeesLocalDataSource
) : EmployeesRepository {

    override suspend fun getEmployees(idSpecialty: Long): Result<Employees> =
        when (val response = safeDatabaseCall { localDataSource.fetchEmployees() }) {
            is Result.Success -> {
                if (response.data.isEmpty()) {
                    getEmployeesRemote(idSpecialty)
                } else {
                    Result.Success(response.data.getEmployeesByIdSpecialty(idSpecialty))
                }
            }
            is Result.Error -> {
                getEmployeesRemote(idSpecialty)
            }
        }


    private suspend fun getEmployeesRemote(idSpecialty: Long): Result<Employees> =
        when (val response = safeApiCall { remoteDataSource.getEmployees() }) {
            is Result.Success -> {
                val employees = response.data.response
                insertEmployees(employees)
                Result.Success(response.data.getEmployees(idSpecialty))
            }
            is Result.Error -> Result.Error(response.exception)
        }


    private suspend fun insertEmployees(employees: Employees) {
        safeDatabaseCall { localDataSource.insertEmployees(employees) }
    }
}