package com.example.myapplication.repository

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitAPIService {

    @Headers("Content-Type: application/json")
    @GET("company/newlisting")
    suspend fun getNewListing(): Response<List<CompaniesBean>>
}