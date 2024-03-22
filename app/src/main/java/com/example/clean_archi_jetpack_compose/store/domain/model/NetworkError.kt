package com.example.clean_archi_jetpack_compose.store.domain.model

data class NetworkError(
    val error: ApiError,
    val t: Throwable?= null
)

enum class ApiError(val message: String){
    NetworkError("Network error"),
    UnknownResponse("Unknown response"),
    UnknownError("Unknown error")
}


