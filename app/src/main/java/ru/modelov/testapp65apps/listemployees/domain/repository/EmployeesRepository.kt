package ru.modelov.testapp65apps.listemployees.domain.repository

import ru.modelov.testapp65apps.main.domain.entities.Employees
import ru.modelov.testapp65apps.main.network.Result

interface EmployeesRepository {
    suspend fun getEmployees(idSpecialty: Long): Result<Employees>
    suspend fun insertEmployees(employees: Employees)
}