package com.codegarage.testcurrency.presentation.currencyconverter.di

import com.codegarage.testcurrency.application.currencyconverter.CurrencyConverterViewModelImpl
import com.codegarage.testcurrency.common.ProductionDispatcherProvider
import com.codegarage.testcurrency.infrastructure.datasource.remote.RemoteDataSourceImpl
import com.codegarage.testcurrency.infrastructure.repository.CurrencyRepositoryImpl

val viewModel = CurrencyConverterViewModelImpl(
    CurrencyRepositoryImpl(
        RemoteDataSourceImpl(
            baseUrl = "https://v6.exchangerate-api.com/v6/052ed078bc95b17efb681daa",
            dispatcherProvider = ProductionDispatcherProvider
        )
    ),
    ProductionDispatcherProvider
)