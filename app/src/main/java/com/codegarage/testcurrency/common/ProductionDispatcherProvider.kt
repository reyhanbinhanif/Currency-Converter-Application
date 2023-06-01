package com.codegarage.testcurrency.common

import com.codegarage.testcurrency.common.DispatcherProvider
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

object ProductionDispatcherProvider : DispatcherProvider {
    override fun UI(): CoroutineContext {
        return Dispatchers.Main
    }

    override fun IO(): CoroutineContext {
        return Dispatchers.IO
    }

}