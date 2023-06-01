package com.codegarage.testcurrency.infrastructure.repository

import com.codegarage.testcurrency.common.ResultWrapper
import com.codegarage.testcurrency.domain.entity.ConversionFactor
import com.codegarage.testcurrency.domain.entity.Currency
import com.codegarage.testcurrency.domain.repository.ICurrencyRepository
import com.codegarage.testcurrency.infrastructure.datasource.remote.IRemoteDataSource
import com.codegarage.testcurrency.infrastructure.datasource.remote.dto.toDomain

class CurrencyRepositoryImpl(
    private val remoteDataSource: IRemoteDataSource
) : ICurrencyRepository {

    override suspend fun getAllCurrencies(): ResultWrapper<Exception, List<Currency>> =
        when (val response = remoteDataSource.getAllCurrencies()) {
            is ResultWrapper.Failure -> response
            is ResultWrapper.Success -> ResultWrapper.build { response.result.toDomain() }
        }

    override suspend fun getConversionFactor(
        baseCurrency: Currency,
        targetCurrency: Currency
    ): ResultWrapper<Exception, ConversionFactor> =
        when (val response = remoteDataSource.getConversionFactor(baseCurrency, targetCurrency)) {
            is ResultWrapper.Failure -> response
            is ResultWrapper.Success -> ResultWrapper.build {
                response.result.toDomain(baseCurrency, targetCurrency)
            }

        }
}