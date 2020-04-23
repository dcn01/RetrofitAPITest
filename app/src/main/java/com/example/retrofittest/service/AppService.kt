package com.example.retrofittest.service

import com.example.retrofittest.model.SucLoginBean
import com.example.retrofittest.model.SucUserBean
import retrofit2.Call
import retrofit2.http.*
import java.util.HashMap

interface AppService {

    @POST("oauth/token")
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    fun getAppTokenData(@Header("Authorization") authorization: String, @FieldMap data: HashMap<String, String>): Call<SucLoginBean>


    @GET("/v0/patient/user")
    fun getUserInfo(@Header("Authorization") authorization: String): Call<SucUserBean>
}