package com.hossein_dev.retrofitapiresponse.data.remote

import kotlinx.coroutines.*
import retrofit2.Response
import java.io.IOException
import java.lang.Exception
import java.net.SocketTimeoutException
import kotlin.coroutines.coroutineContext

object HandleApiResponse {

    suspend fun <T : Any> handleWithApiResponse(apiCall: suspend () -> Response<ApiResponse<T>>): ApiResponse<T> {
        val def: Deferred<ApiResponse<T>> = CoroutineScope(coroutineContext).async {
            try {
                val response = apiCall()
                if (response.body() == null) {
                    return@async ApiResponse.Failure(
                        statusCode = response.code(),
                        response.message()
                    )
                }

                val result: T? = response.body()!!.result

                return@async when {
                    response.isSuccessful -> {
                        when {
                            result != null && result !is List<*> -> {
                                ApiResponse.Success(response.body()!!.message, result)
                            }
                            result is List<*> && result.isEmpty() -> {
                                ApiResponse.EmptyState()
                            }
                            result != null -> {
                                ApiResponse.Success(response.body()!!.message, result)
                            }
                            else -> {
                                ApiResponse.EmptyState()
                            }
                        }
                    }

                    else -> ApiResponse.Failure(
                        response.code(), response.message() + response.errorBody()?.string()
                    )
                }
            } catch (e: SocketTimeoutException) {
                return@async ApiResponse.Failure(400, e.localizedMessage)
            } catch (e: IOException) {
                return@async ApiResponse.Failure(400, e.localizedMessage)
            } catch (e: Exception) {
                return@async ApiResponse.Failure(404, e.localizedMessage)
            }
        }
        return def.await()
    }

    fun <T : Any> loading(): ApiResponse<T> {
        return ApiResponse.Loading()
    }
}