package com.codegarage.testcurrency.application.currencyconverter

import com.codegarage.testcurrency.domain.entity.Currency
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface HomePageState {
    val baseCurrency: StateFlow<Currency>
    val targetCurrency: StateFlow<Currency>

    val baseCurrencyDisplay: StateFlow<String>
    val targetCurrencyDisplay: StateFlow<String>

    val isLoading: StateFlow<Boolean>
    val error: StateFlow<String?>

    val effectStream: Flow<CurrencyConverterEffect>
}
