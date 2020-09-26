package ru.modelov.testapp65apps.listemployees.domain.usecase

import ru.modelov.testapp65apps.listemployees.domain.repository.EmployeesRepository
import ru.modelov.testapp65apps.main.domain.entities.Employees
import ru.modelov.testapp65apps.main.network.Result

class GetEmployeesUseCase(private val repository: EmployeesRepository) {

    suspend operator fun invoke(idSpecialty: Long): Result<Employees> =
        repository.getEmployees(idSpecialty)
}