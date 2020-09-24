package ru.modelov.testapp65apps.listemployees.presentation.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.modelov.testapp65apps.databinding.ItemEmployeeBinding
import ru.modelov.testapp65apps.listemployees.presentation.EmployeesViewModel
import ru.modelov.testapp65apps.main.entities.Employee


class EmployeesViewHolder private constructor(
    private val binding: ItemEmployeeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Employee, viewModel: EmployeesViewModel) {
        with(binding) {
            this.viewModel = viewModel
            this.item = item
            executePendingBindings()
        }
    }

    companion object {
        fun from(parent: ViewGroup): EmployeesViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemEmployeeBinding.inflate(layoutInflater, parent, false)
            return EmployeesViewHolder(binding)
        }
    }
}