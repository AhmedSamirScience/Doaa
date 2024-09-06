package com.samirislamic.doaa._01_common._04_stateHandling._01_useCase

sealed class RequestResource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : RequestResource<T>(data)
    /**
     * we return the data here in case of tracing and needs to log the data retrieved
     */
    class ErrorResponse<T>(message: String? ) : RequestResource<T>(null, message)
    class Error<T>(message: String ) : RequestResource<T>(null, message)
}