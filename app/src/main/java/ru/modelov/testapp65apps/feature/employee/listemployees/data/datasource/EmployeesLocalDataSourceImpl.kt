package ru.modelov.testapp65apps.feature.employee.listemployees.data.datasource

import ru.modelov.testapp65apps.feature.employee.listemployees.data.database.EmployeesDatabase
import ru.modelov.testapp65apps.main.domain.entities.Employees

class EmployeesLocalDataSourceImpl(private val dataBase: EmployeesDatabase) :
    EmployeesLocalDataSource {

    override suspend fun fetchEmployees(): Employees = dataBase.employeesDao().fetchEmployees()

    override suspend fun insertEmployees(employees: Employees) =
        dataBase.employeesDao().insertEmployees(employees)
}