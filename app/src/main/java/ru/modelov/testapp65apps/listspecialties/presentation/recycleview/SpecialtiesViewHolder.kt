package ru.modelov.testapp65apps.listspecialties.presentation.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.modelov.testapp65apps.databinding.ItemSpecialtyBinding
import ru.modelov.testapp65apps.listspecialties.presentation.SpecialtiesViewModel
import ru.modelov.testapp65apps.main.domain.entities.Specialty

class SpecialtiesViewHolder private constructor(
    private val binding: ItemSpecialtyBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Specialty, viewModel: SpecialtiesViewModel) {
        with(binding) {
            this.viewModel = viewModel
            this.item = item
            executePendingBindings()
        }
    }

    companion object {
        fun from(parent: ViewGroup): SpecialtiesViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemSpecialtyBinding.inflate(layoutInflater, parent, false)
            return SpecialtiesViewHolder(binding)
        }
    }
}