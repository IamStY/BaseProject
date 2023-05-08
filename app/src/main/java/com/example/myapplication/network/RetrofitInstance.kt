package com.example.myapplication.network

import com.example.myapplication.repository.RetrofitAPIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
      var retrofit: RetrofitAPIService= Retrofit.Builder()
        .baseUrl("https://openapi.twse.com.tw/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(RetrofitAPIService::class.java)
}
