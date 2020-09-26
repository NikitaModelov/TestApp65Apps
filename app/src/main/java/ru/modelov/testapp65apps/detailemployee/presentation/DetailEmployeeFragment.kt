package ru.modelov.testapp65apps.detailemployee.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.modelov.testapp65apps.R
import ru.modelov.testapp65apps.databinding.DetailEmployeeFragmentBinding
import ru.modelov.testapp65apps.main.entities.Employee
import ru.modelov.testapp65apps.main.presentation.BaseFragment

class DetailEmployeeFragment :
    BaseFragment<DetailEmployeeFragmentBinding>(R.layout.detail_employee_fragment) {

    private val viewModel: DetailEmployeeViewModel by viewModel {
        parametersOf(
            arguments?.getSerializable("EMPLOYEE_KEY") as Employee
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        binding.viewModel = viewModel
        return view
    }
}