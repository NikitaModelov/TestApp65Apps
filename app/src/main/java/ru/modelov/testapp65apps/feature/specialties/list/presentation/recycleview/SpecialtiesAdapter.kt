package ru.modelov.testapp65apps.feature.specialties.list.presentation.recycleview

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.modelov.testapp65apps.feature.specialties.list.presentation.SpecialtiesViewModel
import ru.modelov.testapp65apps.main.domain.entities.Specialty

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