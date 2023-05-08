package com.example.myapplication.tools.extentions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

suspend fun <R> launchCatching(
    context: CoroutineContext = EmptyCoroutineContext,
    block: suspend CoroutineScope.() -> R
): Result<R> = withContext(context) {
    runCatching {
        coroutineScope(block)
    }
}