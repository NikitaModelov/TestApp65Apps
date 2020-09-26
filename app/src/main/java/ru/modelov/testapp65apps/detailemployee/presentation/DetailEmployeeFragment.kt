package ru.modelov.testapp65apps.detailemployee.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.modelov.testapp65apps.R
import ru.modelov.testapp65apps.databinding.DetailEmployeeFragmentBinding
import ru.modelov.testapp65apps.detailemployee.presentation.recycleview.DetailEmployeeAdapter
import ru.modelov.testapp65apps.main.domain.entities.Employee
import ru.modelov.testapp65apps.main.presentation.BaseFragment
import ru.modelov.testapp65apps.main.presentation.decoration.ItemsDecoration

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
        initRv()
        return view
    }

    private fun initRv() {
        val adapter = DetailEmployeeAdapter()
        binding.rvSpecialtiesDetail.adapter = adapter
        binding.rvSpecialtiesDetail.addItemDecoration(ItemsDecoration(24))
        viewModel.employeeLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it.specialty)
        }
    }
}