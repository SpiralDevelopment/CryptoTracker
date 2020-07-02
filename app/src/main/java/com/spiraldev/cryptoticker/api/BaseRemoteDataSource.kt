package com.spiraldev.cryptoticker.api

import com.google.gson.Gson
import com.spiraldev.cryptoticker.api.models.GenericResponse
import com.spiraldev.cryptoticker.util.Constants
import okhttp3.ResponseBody
import retrofit2.Response


/**
 * [BaseRemoteDataSource] invokes the network call and converts the response to
 * [Result] which is consumed by the view model.
 */
abstract class BaseRemoteDataSource {

    suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.Success(body)
            } else if (response.errorBody() != null) {
                val errorBody = getErrorBody(response.errorBody())
                return error(errorBody?.message ?: Constants.GENERIC_ERROR)
            }
            return error(Constants.GENERIC_ERROR)
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun error(message: String): Result.Error =
        Result.Error(message)

    private fun getErrorBody(responseBody: ResponseBody?): GenericResponse? =
        try {
            Gson().fromJson(responseBody?.charStream(), GenericResponse::class.java)
        } catch (e: Exception) {
            null
        }
}