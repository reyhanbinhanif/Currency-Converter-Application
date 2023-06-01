package com.codegarage.testcurrency.application.currencyconverter

import com.codegarage.testcurrency.domain.entity.Currency

sealed class CurrencyConverterEvent {
    object EvaluatePressed : CurrencyConverterEvent()
    object SwitchCurrenciesPressed : CurrencyConverterEvent()
    object BaseCurrencyChangeRequested : CurrencyConverterEvent()
    object TargetCurrencyChangeRequested : CurrencyConverterEvent()
    object PullToRefresh : CurrencyConverterEvent()
    object OnStop: CurrencyConverterEvent()
    data class CurrencySelected(val currency: Currency) : CurrencyConverterEvent()
    data class SearchDisplayTextChanged(val newText: String) : CurrencyConverterEvent()
    data class BaseCurrencyDisplayTextChanged(val newText: String) : CurrencyConverterEvent()
}