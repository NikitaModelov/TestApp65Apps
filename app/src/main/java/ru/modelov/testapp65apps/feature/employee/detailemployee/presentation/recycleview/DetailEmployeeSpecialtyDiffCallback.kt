package ru.modelov.testapp65apps.feature.employee.detailemployee.presentation.recycleview

import androidx.recyclerview.widget.DiffUtil
import ru.modelov.testapp65apps.main.domain.entities.Specialty

class DetailEmployeeSpecialtyDiffCallback : DiffUtil.ItemCallback<Specialty>() {

    override fun areItemsTheSame(oldItem: Specialty, newItem: Specialty) =
        oldItem.specialtyId == newItem.specialtyId

    override fun areContentsTheSame(oldItem: Specialty, newItem: Specialty) =
        oldItem == newItem
}