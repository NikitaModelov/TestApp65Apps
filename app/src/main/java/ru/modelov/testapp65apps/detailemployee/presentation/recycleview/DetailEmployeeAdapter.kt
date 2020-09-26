package ru.modelov.testapp65apps.detailemployee.presentation.recycleview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.modelov.testapp65apps.main.entities.Specialty

class DetailEmployeeAdapter :
    ListAdapter<Specialty, DetailEmployeeViewHolder>(DetailEmployeeSpecialtyDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailEmployeeViewHolder = DetailEmployeeViewHolder.from(parent)

    override fun onBindViewHolder(
        holder: DetailEmployeeViewHolder,
        position: Int
    ) = holder.bind(getItem(position))
}

class DetailEmployeeSpecialtyDiffCallback : DiffUtil.ItemCallback<Specialty>() {

    override fun areItemsTheSame(oldItem: Specialty, newItem: Specialty) =
        oldItem.specialtyId == newItem.specialtyId

    override fun areContentsTheSame(oldItem: Specialty, newItem: Specialty) =
        oldItem == newItem
}