package ru.modelov.testapp65apps.listspecialties.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.modelov.testapp65apps.main.domain.entities.Specialty

@Database(entities = [Specialty::class], version = 1, exportSchema = false)
abstract class SpecialtiesDatabase : RoomDatabase() {

    abstract fun specialtyDao(): SpecialtyDao
}