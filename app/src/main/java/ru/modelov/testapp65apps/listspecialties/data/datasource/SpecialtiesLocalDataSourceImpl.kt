package ru.modelov.testapp65apps.listspecialties.data.datasource

import ru.modelov.testapp65apps.listspecialties.data.database.SpecialtiesDatabase
import ru.modelov.testapp65apps.main.domain.entities.Specialties

class SpecialtiesLocalDataSourceImpl(private val database: SpecialtiesDatabase) :
    SpecialtiesLocalDataSource {

    override suspend fun fetchSpecialties(): Specialties = database.specialtyDao().fetchSpecialty()

    override suspend fun insertSpecialties(specialties: Specialties) {
        database.specialtyDao().insertAll(specialties)
    }
}