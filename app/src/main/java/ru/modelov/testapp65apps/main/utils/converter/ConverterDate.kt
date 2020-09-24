package ru.modelov.testapp65apps.main.utils.converter

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object ConverterDate {
    private val pattern = Regex("^\\d{2}-\\d{2}-\\d{4}$")

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    @SuppressLint("SimpleDateFormat")
    fun getAge(birthday: String?): String? {
        return if (birthday != null && birthday.isNotEmpty()) {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
            if (pattern.matches(birthday)) simpleDateFormat.applyPattern("dd-MM-yyyy")

            val calendarBirthday = Calendar.getInstance()
            calendarBirthday.time = simpleDateFormat.parse(birthday)

            (Calendar.getInstance()
                .get(Calendar.YEAR) - calendarBirthday.get(Calendar.YEAR)).toString()
        } else {
            "-"
        }
    }
}