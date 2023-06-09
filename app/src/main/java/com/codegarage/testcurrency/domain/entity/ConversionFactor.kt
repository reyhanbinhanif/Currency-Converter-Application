package com.codegarage.testcurrency.domain.entity

import kotlinx.datetime.Instant

data class ConversionFactor(
    val baseCurrency: Currency,
    val targetCurrency: Currency,
    val rate: Double,
    val lastUpdate: Instant
)
