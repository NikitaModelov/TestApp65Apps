package ru.modelov.testapp65apps.feature.employee.detailemployee.presentation.recycleview

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.modelov.testapp65apps.main.domain.entities.Specialty

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