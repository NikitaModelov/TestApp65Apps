package ru.modelov.testapp65apps.main.utils.wrapper

import ru.modelov.testapp65apps.main.entities.Employees
import ru.modelov.testapp65apps.main.entities.MyResponse
import ru.modelov.testapp65apps.main.entities.Specialties
import ru.modelov.testapp65apps.main.entities.Specialty

fun MyResponse.getSpecialties(): Specialties {
    val specialties = mutableSetOf<Specialty>()
    this.response.forEach {
        specialties.addAll(it.specialty)
    }
    return specialties.toList()
}

fun MyResponse.getEmployees(idSpecialty: Long): Employees = this.response.filter {
    isContainsSpecialty(it.specialty, idSpecialty)
}

fun Specialties.getSpecialtyById(id: Long): Specialty =
    this.single {
        it.specialtyId == id
    }

private fun isContainsSpecialty(specialties: Specialties, idSpecialty: Long): Boolean =
    specialties.contains(specialties.getSpecialtyById(idSpecialty))

