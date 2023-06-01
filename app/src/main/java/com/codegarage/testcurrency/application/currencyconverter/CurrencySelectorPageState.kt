package com.codegarage.testcurrency.application.currencyconverter

import com.codegarage.testcurrency.domain.entity.Currency
import kotlinx.coroutines.flow.StateFlow

interface CurrencySelectorPageState {
    val currencyList: StateFlow<List<Currency>>
    val searchDisplay: StateFlow<String>

    val isLoading: StateFlow<Boolean>
    val pullToRefreshVisible: StateFlow<Boolean>
    val error: StateFlow<String?>
}