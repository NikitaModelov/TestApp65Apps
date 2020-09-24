package ru.modelov.testapp65apps.listemployees.presentation.databinding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import ru.modelov.testapp65apps.main.utils.converter.ConverterDate.getAge

@BindingAdapter("setAge")
fun TextView.setAge(birthday: String?) {
    text = getAge(birthday)
}