package com.example.clean_archi_jetpack_compose.store.data.mapper

import android.net.http.HttpException
import com.example.clean_archi_jetpack_compose.store.domain.model.ApiError
import com.example.clean_archi_jetpack_compose.store.domain.model.NetworkError
import java.io.IOException


fun Throwable.toNetworkError(): NetworkError{
    val error = when(this){
        is IOException -> ApiError.NetworkError
        is retrofit2.HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError


    }
    return NetworkError(
        error = error,
        t = this
    )
}