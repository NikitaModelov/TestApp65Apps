package ru.modelov.testapp65apps.listspecialties.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.specialties_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel
import ru.modelov.testapp65apps.R

class SpecialtiesFragment : Fragment() {

    private val viewModel: SpecialtiesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.specialties_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}