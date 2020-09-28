package ru.modelov.testapp65apps.feature.employee.detailemployee.presentation.bindingadapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import ru.modelov.testapp65apps.R
import ru.modelov.testapp65apps.main.utils.converter.ConverterDate.getBirthday

@BindingAdapter("setBirthday")
fun TextView.setBirthday(birthday: String?) {
    text = resources.getString(R.string.employee_birthday, getBirthday(birthday))
}