package com.example.retrofittest

import com.example.retrofittest.service.AppService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * Created by juwuguo on 2020-04-22.
 */
object APINetWork {

    suspend fun getAccessToken(authorization: String, data: HashMap<String, String>) =
        ServiceCreator.create<AppService>().getAppTokenData(authorization, data).awaited()


    private suspend fun <T> Call<T>.awaited(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}