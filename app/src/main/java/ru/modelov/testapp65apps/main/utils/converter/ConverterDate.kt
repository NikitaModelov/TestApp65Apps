package ru.modelov.testapp65apps.main.utils.converter

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object ConverterDate {
    private val firstPattern = Regex("^\\d{2}-\\d{2}-\\d{4}$")

    fun getAge(birthday: String?): String {
        val calendarBirthday = getDefaultFormat(birthday)
        return calendarBirthday?.let {
            (Calendar.getInstance()
                .get(Calendar.YEAR) - calendarBirthday.get(Calendar.YEAR)).toString()
        } ?: "-"
    }

    fun getBirthday(birthday: String?): String {
        val calendarBirthday = getDefaultFormat(birthday)
        return calendarBirthday?.let {
            val format = SimpleDateFormat("dd.MM.yyyy")
            format.format(it.time)
        } ?: "-"
    }

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    @SuppressLint("SimpleDateFormat")
    private fun getDefaultFormat(birthday: String?): Calendar? {
        return if (birthday != null && birthday.isNotEmpty()) {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
            if (firstPattern.matches(birthday))
                simpleDateFormat.applyPattern("dd-MM-yyyy")

            Calendar.getInstance().apply { time = simpleDateFormat.parse(birthday) }
        } else {
            null
        }
    }
}