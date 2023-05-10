package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.database.AppDatabase
import com.example.myapplication.repository.RetrofitAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofitService(): RetrofitAPIService {
        return Retrofit.Builder()
            .baseUrl("https://openapi.twse.com.tw/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitAPIService::class.java)
    }
}
