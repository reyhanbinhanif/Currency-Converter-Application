package com.codegarage.testcurrency.application.currencyconverter

sealed class CurrencyConverterEffect {
    data class ShowToast(val message: String) : CurrencyConverterEffect()
}
