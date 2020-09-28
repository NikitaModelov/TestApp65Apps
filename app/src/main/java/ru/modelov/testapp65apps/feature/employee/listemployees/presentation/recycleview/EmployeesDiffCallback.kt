package ru.modelov.testapp65apps.feature.employee.listemployees.presentation.recycleview

import androidx.recyclerview.widget.DiffUtil
import ru.modelov.testapp65apps.main.domain.entities.Employee

class EmployeesDiffCallback : DiffUtil.ItemCallback<Employee>() {

    override fun areItemsTheSame(oldItem: Employee, newItem: Employee) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Employee, newItem: Employee) =
        oldItem == newItem
}