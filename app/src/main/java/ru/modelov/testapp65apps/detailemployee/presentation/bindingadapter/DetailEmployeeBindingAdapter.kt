package ru.modelov.testapp65apps.detailemployee.presentation.bindingadapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import ru.modelov.testapp65apps.main.utils.converter.ConverterDate.getBirthday

@BindingAdapter("setBirthday")
fun TextView.setBirthday(birthday: String?) {
    text = "Дата рождения: " + getBirthday(birthday) + "г."
}