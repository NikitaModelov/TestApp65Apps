package ru.modelov.testapp65apps.listemployees.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.modelov.testapp65apps.main.domain.entities.Employee

@Database(entities = [Employee::class], version = 1, exportSchema = false)
abstract class EmployeesDatabase : RoomDatabase() {

    abstract fun employeesDao(): EmployeesDao
}