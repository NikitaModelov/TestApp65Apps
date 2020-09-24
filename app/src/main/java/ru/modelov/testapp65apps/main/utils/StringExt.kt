package ru.modelov.testapp65apps.main.utils

fun String.toUpperCaseFirstSymbol(): String {
    val firstSymbol = this[0]
    return this.toLowerCase().replaceRange(0..0, firstSymbol.toUpperCase().toString())
}