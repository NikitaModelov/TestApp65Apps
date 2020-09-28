package ru.modelov.testapp65apps.feature.employee.listemployees.domain.repository

import ru.modelov.testapp65apps.main.domain.entities.Employees
import ru.modelov.testapp65apps.main.network.Result

interface EmployeesRepository {
    suspend fun getEmployees(idSpecialty: Long): Result<Employees>
}