package ru.modelov.testapp65apps.feature.specialties.list.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.modelov.testapp65apps.R
import ru.modelov.testapp65apps.databinding.SpecialtiesFragmentBinding
import ru.modelov.testapp65apps.feature.specialties.list.presentation.recycleview.SpecialtiesAdapter
import ru.modelov.testapp65apps.main.presentation.BaseFragment
import ru.modelov.testapp65apps.main.presentation.decoration.ItemsDecoration
import ru.modelov.testapp65apps.main.utils.bundle.BundleKey.ID_SPECIALTY

class SpecialtiesFragment : BaseFragment<SpecialtiesFragmentBinding>(R.layout.specialties_fragment),
    SpecialtiesViewModel.EventsListener {

    private val viewModel: SpecialtiesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        binding.viewModel = viewModel
        viewModel.eventsDispatcher.bind(viewLifecycleOwner, this)
        initSpecialtiesRv()

        return view
    }

    private fun initSpecialtiesRv() {
        val adapter = SpecialtiesAdapter(viewModel)
        binding.rvSpecialties.adapter = adapter
        binding.rvSpecialties.addItemDecoration(
            ItemsDecoration()
        )

        viewModel.specialtiesLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun navigateToEmployees(id: Long) {
        findNavController().navigate(
            R.id.action_specialties_to_employees,
            bundleOf(ID_SPECIALTY to id)
        )
    }
}