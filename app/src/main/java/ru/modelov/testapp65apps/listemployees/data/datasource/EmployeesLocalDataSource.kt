package ru.modelov.testapp65apps.listemployees.data.datasource

import ru.modelov.testapp65apps.main.domain.entities.Employees

interface EmployeesLocalDataSource {
    suspend fun fetchEmployees(): Employees
    suspend fun insertEmployees(employees: Employees)
}