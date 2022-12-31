package com.example.zad8.data

import com.example.zad8.data.model.RequestModel
import com.example.zad8.data.model.ResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("api/token/")
    fun sendReq(@Body requestModel: RequestModel) : Call<ResponseModel>
}