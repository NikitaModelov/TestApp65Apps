package ru.modelov.testapp65apps.feature.specialties.list.data.datasource

import ru.modelov.testapp65apps.feature.specialties.list.data.database.SpecialtiesDatabase
import ru.modelov.testapp65apps.main.domain.entities.Specialties

class SpecialtiesLocalDataSourceImpl(private val database: SpecialtiesDatabase) :
    SpecialtiesLocalDataSource {

    override suspend fun fetchSpecialties(): Specialties = database.specialtyDao().fetchSpecialty()

    override suspend fun insertSpecialties(specialties: Specialties) {
        database.specialtyDao().insertAll(specialties)
    }
}