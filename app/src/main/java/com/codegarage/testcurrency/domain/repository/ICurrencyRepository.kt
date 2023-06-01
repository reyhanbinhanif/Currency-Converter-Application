package com.codegarage.testcurrency.domain.repository

import com.codegarage.testcurrency.common.ResultWrapper
import com.codegarage.testcurrency.domain.entity.ConversionFactor
import com.codegarage.testcurrency.domain.entity.Currency

interface ICurrencyRepository {

    suspend fun getAllCurrencies(): ResultWrapper<Exception, List<Currency>>

    suspend fun getConversionFactor(
        baseCurrency: Currency,
        targetCurrency: Currency
    ): ResultWrapper<Exception, ConversionFactor>

}