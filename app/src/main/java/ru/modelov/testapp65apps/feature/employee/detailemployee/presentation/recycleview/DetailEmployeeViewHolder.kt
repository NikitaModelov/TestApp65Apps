package ru.modelov.testapp65apps.feature.employee.detailemployee.presentation.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.modelov.testapp65apps.databinding.DetailEmployeeSpecialtyItemBinding
import ru.modelov.testapp65apps.main.domain.entities.Specialty

class DetailEmployeeViewHolder private constructor(
    private val binding: DetailEmployeeSpecialtyItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Specialty) {
        with(binding) {
            this.item = item
            executePendingBindings()
        }
    }

    companion object {
        fun from(parent: ViewGroup): DetailEmployeeViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = DetailEmployeeSpecialtyItemBinding.inflate(layoutInflater, parent, false)
            return DetailEmployeeViewHolder(binding)
        }
    }
}