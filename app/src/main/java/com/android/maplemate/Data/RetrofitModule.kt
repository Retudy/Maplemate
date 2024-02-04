package com.android.maplemate.Data

import com.android.maplemate.BuildConfig
import com.android.maplemate.Service.ApiServiceMaple
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitModule {
    private fun buildOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(
                // 로깅 인터셉터
                HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
                }
            )
            .readTimeout(5, TimeUnit.MINUTES)
            .connectTimeout(5, TimeUnit.MINUTES)
            .build()

    private var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    fun createMapleApiService(): ApiServiceMaple {
        return Retrofit.Builder()
            .baseUrl("https://open.api.nexon.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(buildOkHttpClient())
            .build()
            .create(ApiServiceMaple::class.java)
    }


}