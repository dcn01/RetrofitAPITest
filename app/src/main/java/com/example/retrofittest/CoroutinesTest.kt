package com.example.retrofittest

import com.example.retrofittest.model.SucLoginBean
import com.example.retrofittest.service.AppService
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.util.HashMap
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

fun main() {
    runBlocking {
        val loginBean = async {
            val map = HashMap<String, String>()
            map["grant_type"] = "password"
            map["username"] = "17710189466"
            map["password"] = "123456"
            map["device_type"] = "android"
            // 登录的时候添加一下leanCloud 生成的设备id用于推送:
            // AVInstallation.getCurrentInstallation().getInstallationId();
            map["device_token"] = "111111"
            ServiceCreator.create<AppService>().getAppTokenData("Basic cGF0aWVudF9hcHA6", map)
                .await()
        }.await()

        print("========result======" + loginBean.access_token)


        val userResult = async {
            //执行请求token接口
            print("========result111111======" + loginBean.access_token)
            ServiceCreator.create<AppService>().getUserInfo("Bearer " + loginBean.access_token)
                .await()
        }.await()

        print("========userResult======" + userResult.data.user.name)
    }
}

suspend fun printDot() {
    println(".")
    delay(1000)
}

suspend fun getAppData(): SucLoginBean? {
    val map = HashMap<String, String>()
    map["grant_type"] = "password"
    map["username"] = "17710189466"
    map["password"] = "123456"
    map["device_type"] = "android"
    // 登录的时候添加一下leanCloud 生成的设备id用于推送:
    // AVInstallation.getCurrentInstallation().getInstallationId();
    map["device_token"] = "111111"

    try {
        val appList =
            ServiceCreator.create<AppService>().getAppTokenData("Basic cGF0aWVudF9hcHA6", map)
                .await() // 这段代码想运行通过，需要将BASE_URL中的地址改成http://localhost/
        return appList
        // 对服务器响应的数据进行处理
    } catch (e: Exception) {
        // 对异常情况进行处理
        e.printStackTrace()
    }
    return null
}

suspend fun <T> Call<T>.await(): T {
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