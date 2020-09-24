package ru.modelov.testapp65apps.main.utils.wrapper

import ru.modelov.testapp65apps.main.entities.*
import ru.modelov.testapp65apps.main.utils.toUpperCaseFirstSymbol

fun MyResponse.getSpecialties(): Specialties {
    val specialties = mutableSetOf<Specialty>()
    this.response.forEach {
        specialties.addAll(it.specialty)
    }
    return specialties.toList()
}

fun MyResponse.getEmployees(idSpecialty: Long): Employees {
    val employees = this.response
    val result = mutableListOf<Employee>()
    employees.forEach { emp ->
        emp.specialty.getSpecialtyById(idSpecialty).let {
            if (emp.specialty.contains(it))
                result.add(emp)
        }
    }
    result.map {
        it.lastName = it.lastName.toUpperCaseFirstSymbol()
        it.firstName = it.firstName.toUpperCaseFirstSymbol()
    }.toList()
    return result
}

private fun Specialties.getSpecialtyById(id: Long): Specialty? {
    this.forEach {
        if (it.specialtyId == id) return it
    }
    return null
}