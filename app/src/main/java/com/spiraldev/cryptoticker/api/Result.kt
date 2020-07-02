package com.spiraldev.cryptoticker.api


/**
 * [Result] is a helper class to wrap the response from backend.
 * [Success] contains the original response.
 * [Error] contains the error message in case of service class error.
 * [Loading] denotes whether there is a network call happening or not
 */
sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when(this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[message=$message]"
            is Loading -> "Loading"
        }
    }
}

val Result<*>.succeeded
    get() = this is Result.Success && data != null

//suspend fun <T> result(networkCall: suspend () -> Result<T>): Result<T> = networkCall.invoke()