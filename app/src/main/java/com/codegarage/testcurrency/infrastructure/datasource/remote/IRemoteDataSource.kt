package com.codegarage.testcurrency.infrastructure.datasource.remote

import com.codegarage.testcurrency.common.ResultWrapper
import com.codegarage.testcurrency.domain.entity.Currency
import com.codegarage.testcurrency.infrastructure.datasource.remote.dto.PairConversion
import com.codegarage.testcurrency.infrastructure.datasource.remote.dto.SupportedCodes

interface IRemoteDataSource {
    suspend fun getAllCurrencies(): ResultWrapper<Exception, SupportedCodes>

    suspend fun getConversionFactor(
        baseCurrency: Currency,
        targetCurrency: Currency,
    ): ResultWrapper<Exception, PairConversion>
}