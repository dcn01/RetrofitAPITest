package com.example.retrofittest

import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import java.lang.RuntimeException
import java.util.HashMap
import kotlin.coroutines.CoroutineContext

/**
 * Created by juwuguo on 2020-04-21.
 */
object RepositoryControllor {
    fun getAccessToken(authorization: String, data: HashMap<String, String>) =
        fire(Dispatchers.IO) {
            val tokenResponse = APINetWork.getAccessToken(authorization, data)
            if (tokenResponse.access_token != null) {
                Result.success(tokenResponse)
            } else {
                Result.failure(RuntimeException("response status is ${tokenResponse.error_description}"))
            }
        }

    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }
}