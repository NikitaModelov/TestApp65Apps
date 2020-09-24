package ru.modelov.testapp65apps.listemployees.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.modelov.testapp65apps.R
import ru.modelov.testapp65apps.databinding.EmployeesFragmentBinding
import ru.modelov.testapp65apps.main.presentation.BaseFragment

class EmployeesFragment : BaseFragment<EmployeesFragmentBinding>(R.layout.employees_fragment),
    EmployeesViewModel.EventsListener {

    val viewModel: EmployeesViewModel by viewModel {
        parametersOf(
            arguments?.getLong("ID_SPECIALTY")
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        binding.viewModel = viewModel
        viewModel.eventsDispatcher.bind(viewLifecycleOwner, this)
        //initRv()

        return view
    }

    /*private fun initRv() {
        val adapter = SpecialtiesAdapter(viewModel)
        binding.rvEmployees.adapter = adapter
        binding.rvEmployees.addItemDecoration(SpecialtiesItemsDecoration(24))

        viewModel.specialtiesLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }*/
}