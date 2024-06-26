package com.alijan.newsapp_cleanarc.common.base

sealed class NetworkResponse<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : NetworkResponse<T>(data)
    class Loading<T>(data: T? = null) : NetworkResponse<T>(data)
    class Error<T>(message: String, data: T? = null) : NetworkResponse<T>(data, message)
}