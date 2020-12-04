package com.example.applicationpokemon.core.utils.helpers

import com.example.applicationpokemon.core.utils.ResponseWrapper

abstract class BaseApiHelper<T, R> {
    abstract suspend fun handleApiResponse(response: T): ResponseWrapper<R>
}
