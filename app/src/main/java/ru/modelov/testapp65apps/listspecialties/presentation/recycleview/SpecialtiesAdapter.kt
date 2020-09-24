package ru.modelov.testapp65apps.listspecialties.presentation.recycleview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.modelov.testapp65apps.listspecialties.presentation.SpecialtiesViewModel
import ru.modelov.testapp65apps.main.entities.Specialty

class SpecialtiesAdapter(
    private val viewModel: SpecialtiesViewModel
) : ListAdapter<Specialty, SpecialtiesViewHolder>(SheltersDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SpecialtiesViewHolder = SpecialtiesViewHolder.from(parent)

    override fun onBindViewHolder(
        holder: SpecialtiesViewHolder,
        position: Int
    ) = holder.bind(getItem(position), viewModel)
}

class SheltersDiffCallback : DiffUtil.ItemCallback<Specialty>() {

    override fun areItemsTheSame(oldItem: Specialty, newItem: Specialty) =
        oldItem.specialtyId == newItem.specialtyId

    override fun areContentsTheSame(oldItem: Specialty, newItem: Specialty) =
        oldItem == newItem
}