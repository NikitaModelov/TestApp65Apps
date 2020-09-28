package ru.modelov.testapp65apps.feature.employee.listemployees.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.modelov.testapp65apps.main.domain.entities.Employees

@Dao
interface EmployeesDao {

    @Query("SELECT * FROM Employees")
    suspend fun fetchEmployees(): Employees

    @Insert
    suspend fun insertEmployees(employees: Employees)
}