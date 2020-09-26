package ru.modelov.testapp65apps.listemployees.presentation.recycleview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.modelov.testapp65apps.listemployees.presentation.EmployeesViewModel
import ru.modelov.testapp65apps.main.domain.entities.Employee

class EmployeesAdapter(
    private val viewModel: EmployeesViewModel
) : ListAdapter<Employee, EmployeesViewHolder>(EmployeesDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeesViewHolder = EmployeesViewHolder.from(parent)

    override fun onBindViewHolder(
        holder: EmployeesViewHolder,
        position: Int
    ) = holder.bind(getItem(position), viewModel)
}

class EmployeesDiffCallback : DiffUtil.ItemCallback<Employee>() {

    override fun areItemsTheSame(oldItem: Employee, newItem: Employee) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Employee, newItem: Employee) =
        oldItem == newItem
}