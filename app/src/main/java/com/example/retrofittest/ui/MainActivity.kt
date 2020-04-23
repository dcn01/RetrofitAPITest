package com.example.retrofittest.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofittest.*
import com.example.retrofittest.service.AppService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


class MainActivity : AppCompatActivity() {
    private var app_token: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAppDataBtn.setOnClickListener {
            var job =  Job()
            val scope = CoroutineScope(job)
            scope.launch {
                Log.d("=====launch========","========currentThread======" + android.os.Process.myTid())
                val loginBean = async {
                    Log.d("=====async1========","========currentThread======" + android.os.Process.myTid())
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

                Log.d("=============","========result======" + loginBean.access_token)

                val userResult = async {
                    //执行请求token接口
                    Log.d("=====async2========","========currentThread======" +android.os.Process.myTid())
                    Log.d("=============","========result111111======" + loginBean.access_token)
                    ServiceCreator.create<AppService>().getUserInfo("Bearer " + loginBean.access_token)
                        .await()
                }.await()
                Log.d("=============","========userResult======" + userResult.data.user.name)
            }
        }
    }


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


    private fun getAppData() {
        val map = HashMap<String, String>()
        map["grant_type"] = "password"
        map["username"] = "17710189466"
        map["password"] = "123456"
        map["device_type"] = "android"
        // 登录的时候添加一下leanCloud 生成的设备id用于推送:
        // AVInstallation.getCurrentInstallation().getInstallationId();
        map["device_token"] = "111111"

        try {
            var result = RepositoryControllor.getAccessToken(
                "Basic cGF0aWVudF9hcHA6",
                map
            )
            // 这段代码想运行通过，需要将BASE_URL中的地址改成http://localhost/
            println("=======result=====>" + result.value)
            // 对服务器响应的数据进行处理
        } catch (e: Exception) {
            // 对异常情况进行处理
            e.printStackTrace()
        }
    }

}


