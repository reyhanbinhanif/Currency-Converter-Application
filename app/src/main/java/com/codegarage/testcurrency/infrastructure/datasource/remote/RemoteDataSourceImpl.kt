package com.codegarage.testcurrency.infrastructure.datasource.remote

import com.codegarage.testcurrency.common.DispatcherProvider
import com.codegarage.testcurrency.common.ResultWrapper
import com.codegarage.testcurrency.domain.entity.Currency
import com.codegarage.testcurrency.infrastructure.datasource.remote.IRemoteDataSource
import com.codegarage.testcurrency.infrastructure.datasource.remote.dto.PairConversion
import com.codegarage.testcurrency.infrastructure.datasource.remote.dto.SupportedCodes
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*

class RemoteDataSourceImpl(
    private val baseUrl: String,
    private val dispatcherProvider: DispatcherProvider,
) : IRemoteDataSource {

    private val client = HttpClient(Android) {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }

        engine {
            connectTimeout = 60_000
            socketTimeout = 60_000
        }
    }

    override suspend fun getAllCurrencies(): ResultWrapper<Exception, SupportedCodes> =
        ResultWrapper.build {
            client.get {
                url("$baseUrl/codes")
            }
        }


    override suspend fun getConversionFactor(
        baseCurrency: Currency,
        targetCurrency: Currency
    ): ResultWrapper<Exception, PairConversion> =
        ResultWrapper.build {
            client.get {
                url("$baseUrl/pair/${baseCurrency.code}/${targetCurrency.code}")
            }
        }
}