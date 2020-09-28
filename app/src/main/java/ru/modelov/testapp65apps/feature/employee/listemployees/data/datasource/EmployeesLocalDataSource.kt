package ru.modelov.testapp65apps.feature.employee.listemployees.data.datasource

import ru.modelov.testapp65apps.main.domain.entities.Employees

interface EmployeesLocalDataSource {
    suspend fun fetchEmployees(): Employees
    suspend fun insertEmployees(employees: Employees)
}