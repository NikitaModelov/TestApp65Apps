package ru.modelov.testapp65apps.listemployees.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.modelov.testapp65apps.R
import ru.modelov.testapp65apps.databinding.EmployeesFragmentBinding
import ru.modelov.testapp65apps.listemployees.presentation.recycleview.EmployeesAdapter
import ru.modelov.testapp65apps.main.entities.Employee
import ru.modelov.testapp65apps.main.presentation.BaseFragment
import ru.modelov.testapp65apps.main.presentation.decoration.ItemsDecoration

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
        initRv()

        return view
    }

    private fun initRv() {
        val adapter = EmployeesAdapter(viewModel)
        binding.rvEmployees.adapter = adapter
        binding.rvEmployees.addItemDecoration(ItemsDecoration(24))

        viewModel.employeesLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun navigateToDetailEmployee(employee: Employee) {
        findNavController().navigate(
            R.id.action_employees_to_detail_employee,
            bundleOf("EMPLOYEE_KEY" to employee)
        )
    }
}